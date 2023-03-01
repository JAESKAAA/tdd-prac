package com.example.tddprac;

import com.google.common.base.CaseFormat;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.metamodel.EntityType;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 해당 클래스의 역할
 * 테스트 완료 후, 테이블 초기화와 sequence 초기화를 담당해 준다.
 *
 * 의문 사항 = @Transactional을 통해 롤백시키는 것과 어떤 차이가 있을지 ?
 */

@Component
public class DatabaseCleanUp implements InitializingBean {

    @PersistenceContext
    private EntityManager entityManager;

    private List<String> tableNames;

    @Override
    public void afterPropertiesSet() throws Exception {
        final Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        tableNames = entities.stream()
            .filter(e -> isEntity(e) && hasTableAnnotation(e))
            .map(e -> e.getJavaType().getAnnotation(Table.class).name())
            .toList();

        final List<String> entityNames = entities.stream()
            .filter(e -> isEntity(e) && !hasTableAnnotation(e))
            //productNames -> product_names로 변경해준다.
            .map(e -> CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, e.getName())) //CaseFormat은 Guava 라이브러리 사용
            .toList();


    }

    @Transactional
    public void execute() {
        entityManager.flush();

        //참조 무결성 조건 잠시 off (외래키 잡힌 테이블 삭제시 SQL 오류 발생을 막기 위함)
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();

        for (final String tableName : tableNames) {

            //테이블 비워주고,
            entityManager.createNativeQuery("TRUNCATE TABLE " + tableName).executeUpdate();
            //자동 생성되는 ID 값을 1로 초기화 시켜줌
            entityManager.createNativeQuery("ALTER TABLE " + tableName + " ALTER COLUMN ID RESTART WITH 1").executeUpdate();
        }

        //참조무결성 off를 다시 on해줌
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();


    }

    private boolean hasTableAnnotation(EntityType<?> e) {
        return null != e.getJavaType().getAnnotation(Table.class);
    }

    private boolean isEntity(final EntityType<?> e) {
        return null != e.getJavaType().getAnnotation(Entity.class);
    }
}
