package com.inventory.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVendor is a Querydsl query type for Vendor
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVendor extends EntityPathBase<Vendor> {

    private static final long serialVersionUID = 435601934L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVendor vendor = new QVendor("vendor");

    public final StringPath address = createString("address");

    public final StringPath city = createString("city");

    public final QCompany company;

    public final StringPath country = createString("country");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final ArrayPath<byte[], Byte> logo = createArray("logo", byte[].class);

    public final StringPath mobile = createString("mobile");

    public final StringPath name = createString("name");

    public final StringPath notes = createString("notes");

    public final ListPath<Product, QProduct> products = this.<Product, QProduct>createList("products", Product.class, QProduct.class, PathInits.DIRECT2);

    public final BooleanPath status = createBoolean("status");

    public QVendor(String variable) {
        this(Vendor.class, forVariable(variable), INITS);
    }

    public QVendor(Path<? extends Vendor> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVendor(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVendor(PathMetadata metadata, PathInits inits) {
        this(Vendor.class, metadata, inits);
    }

    public QVendor(Class<? extends Vendor> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company")) : null;
    }

}

