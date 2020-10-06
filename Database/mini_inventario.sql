drop database if exists inventario;
create database inventario charset utf8 collate utf8_spanish_ci;
use inventario;

drop table if exists producto;
create table producto(
producto_code varchar(150) not null primary key,
producto_nombre varchar(150) not null,
producto_unidad varchar(20) not null,
producto_precio decimal(20,2) not null
)engine innodb;

insert into producto(producto_code, producto_nombre, producto_unidad, producto_precio) 
values('A4454', 'Aceite', 'Botella 700ml', '1.25');

drop table if exists caracteristica;
create table caracteristica(
caracteristica_id int auto_increment primary key,
caracteristica_nombre varchar(50) not null,
caracteristica_comentario varchar(150),
caracteristica_producto varchar(150) not null,
constraint fk_car_pro foreign key(caracteristica_producto) references producto(producto_code) on update cascade on delete cascade
)engine innodb;