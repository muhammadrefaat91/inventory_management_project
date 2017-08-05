package com.inventory.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCompany is a Querydsl query type for Company
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompany extends EntityPathBase<Company> {

    private static final long serialVersionUID = 1221769335L;

    public static final QCompany company = new QCompany("company");

    public final StringPath address = createString("address");

    public final StringPath email = createString("email");

    public final StringPath faxNumber = createString("faxNumber");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final ArrayPath<byte[], Byte> logo = createArray("logo", byte[].class);

    public final StringPath name = createString("name");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath registrationNumber = createString("registrationNumber");

    public QCompany(String variable) {
        super(Company.class, forVariable(variable));
    }

    public QCompany(Path<? extends Company> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCompany(PathMetadata metadata) {
        super(Company.class, metadata);
    }

}

