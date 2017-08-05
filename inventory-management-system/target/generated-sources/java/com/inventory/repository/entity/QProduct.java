package com.inventory.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = -38188823L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final StringPath barCode = createString("barCode");

    public final NumberPath<Double> costPrice = createNumber("costPrice", Double.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final ArrayPath<byte[], Byte> image = createArray("image", byte[].class);

    public final StringPath location = createString("location");

    public final NumberPath<Integer> maxQuantity = createNumber("maxQuantity", Integer.class);

    public final NumberPath<Integer> minQunatity = createNumber("minQunatity", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Double> quantity = createNumber("quantity", Double.class);

    public final NumberPath<Double> salePrice = createNumber("salePrice", Double.class);

    public final BooleanPath status = createBoolean("status");

    public final QVendor vendor;

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.vendor = inits.isInitialized("vendor") ? new QVendor(forProperty("vendor"), inits.get("vendor")) : null;
    }

}

