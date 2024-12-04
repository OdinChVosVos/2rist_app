CREATE TABLE public.places (
	id serial NOT NULL,
	category_id integer NOT NULL,
	name varchar(100) NOT NULL unique,
	url varchar,
	adress varchar,
	time_work varchar,
	position varchar,
	CONSTRAINT places_pk PRIMARY KEY (id)
);

CREATE TABLE public.images (
	id serial NOT NULL,
	image varchar NOT NULL,
	place_id integer NOT NULL,
	CONSTRAINT places_pk PRIMARY KEY (id)
);

CREATE TABLE public.tags (
	id serial NOT NULL,
	name varchar(100) NOT NULL,
	CONSTRAINT tags_pk PRIMARY KEY (id)
);

CREATE TABLE public.categories (
	id serial NOT NULL,
	name varchar(100) NOT NULL,
	CONSTRAINT categories_pk PRIMARY KEY (id)
);

CREATE TABLE public.tags_places (
	id serial NOT NULL,
	place_id integer NOT NULL,
	tag_id integer NOT NULL,
	CONSTRAINT tags_places_pk PRIMARY KEY (id)
);


CREATE TABLE public.users (
	id serial NOT NULL,
	mail varchar(100) NOT NULL UNIQUE,
	password varchar NOT NULL,
	phone varchar(15) NULL,
	firstname varchar(100),
	lastname varchar(100),
	login varchar(100) NOT NULL UNIQUE,
	role varchar(100),
	CONSTRAINT users_pk PRIMARY KEY (id)
);

CREATE TABLE public.interests(
	id serial NOT NULL,
	user_id integer NOT NULL,
	tag_id integer NOT NULL,
    coeff float(3) NOT NULL,
	CONSTRAINT interests_tags_pk PRIMARY KEY (id)
);


CREATE SEQUENCE users_seq START 1 OWNED BY users.id;
CREATE SEQUENCE categories_seq START 4 OWNED BY categories.id;
CREATE SEQUENCE tags_seq START 21 OWNED BY tags.id;
CREATE SEQUENCE interests_seq START 1 OWNED BY interests.id;
CREATE SEQUENCE places_seq START 10 OWNED BY places.id;
CREATE SEQUENCE tags_places_seq START 26 OWNED BY tags_places.id;
CREATE SEQUENCE images_seq START 20 OWNED BY images.id;

ALTER TABLE places ADD CONSTRAINT places_fk0 FOREIGN KEY (category_id) REFERENCES categories(id);
ALTER TABLE tags_places ADD CONSTRAINT tags_places_fk0 FOREIGN KEY (place_id) REFERENCES places(id);
ALTER TABLE tags_places ADD CONSTRAINT tags_places_fk1 FOREIGN KEY (tag_id) REFERENCES tags(id);
ALTER TABLE interests ADD CONSTRAINT interests_fk0 FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE interests ADD CONSTRAINT interests_fk1 FOREIGN KEY (tag_id) REFERENCES tags(id);
ALTER TABLE images ADD CONSTRAINT images_fk0 FOREIGN KEY (place_id) REFERENCES places(id);


INSERT INTO users (id, mail, password, login, role) VALUES (0, 'Admin', '$2a$10$bWeuWYhzH72vPoHky7o.9Ouwiz6t5k3nfA8anfLHBu8.edDQjE/bS', 'Admin', 'ADMIN');

INSERT INTO categories (id, name) VALUES (1, 'Рестораны');
INSERT INTO categories (id, name) VALUES (2, 'Достопримечательности');
INSERT INTO categories (id, name) VALUES (3, 'Отели');

INSERT INTO tags (id, name) VALUES (1, 'Музей');
INSERT INTO tags (id, name) VALUES (2, 'С детьми');
INSERT INTO tags (id, name) VALUES (3, 'РРР');
INSERT INTO tags (id, name) VALUES (4, 'РР');
INSERT INTO tags (id, name) VALUES (5, 'Р');
INSERT INTO tags (id, name) VALUES (6, '18+');
INSERT INTO tags (id, name) VALUES (7, 'Круглосуточно');
INSERT INTO tags (id, name) VALUES (8, 'В центре');
INSERT INTO tags (id, name) VALUES (9, 'Веган');
INSERT INTO tags (id, name) VALUES (10, 'Японская кухня');
INSERT INTO tags (id, name) VALUES (11, 'Кавказская кухня');
INSERT INTO tags (id, name) VALUES (12, 'Европейская кухня');
INSERT INTO tags (id, name) VALUES (13, 'Кофе');
INSERT INTO tags (id, name) VALUES (14, 'Чай');
INSERT INTO tags (id, name) VALUES (15, 'Сладкое');
INSERT INTO tags (id, name) VALUES (16, 'Алкоголь');
INSERT INTO tags (id, name) VALUES (17, 'Танцы');
INSERT INTO tags (id, name) VALUES (18, 'Настольные игры');
INSERT INTO tags (id, name) VALUES (19, 'Видео игры');
INSERT INTO tags (id, name) VALUES (20, 'Кальян');

INSERT INTO places (id, category_id, name, adress, time_work, position) VALUES (1, 1, "Белуга", "ул. Фиолетова, 1-3, Астрахань",
"Понедельник, 11:00 – 00:00, Вторник 11:00 – 00:00, Среда 11:00 – 00:00, Четверг 11:00 – 00:00, Пятница 11:00 – 00:00, Суббота 11:00 – 00:00, Воскресенье 11:00 – 00:00",
"46.354861 48.033035");
INSERT INTO places (id, category_id, name, url, adress, time_work, position) VALUES (2, 1, "Розмарин", "https://rozmarin.taplink.ws/", "Эспланадная ул., 4А, Астрахань",
"Понедельник 09:00 – 23:00, Вторник 09:00 – 23:00, Среда 09:00 – 23:00, Четверг 09:00 – 23:00, Пятница 09:00 – 23:00, Суббота 09:00 – 23:00, Воскресенье 09:00 – 23:00",
"46.351676 48.035353");
INSERT INTO places (id, category_id, name, url, adress, time_work, position) VALUES (3, 1, "Falafel Cafe", "http://falafelcafe.ru/", "Эспланадная ул., 19/7/28, Астрахань",
"Понедельник 10:00 – 22:00, Вторник 10:00 – 22:00, Среда 10:00 – 22:00, Четверг 10:00 – 22:00, Пятница 10:00 – 22:00, Суббота 10:00 – 22:00, Воскресенье 10:00 – 22:00",
"46.352317 48.038236");

INSERT INTO places (id, category_id, name, url, adress, time_work, position) VALUES (4, 2, "Астраханский Кремль", "https://astmuseum.ru/ru/", "улица В. Тредиаковского, 2/1, Астрахань",
"Понедельник 10:00 – 21:00, Вторник 10:00 – 21:00, Среда 10:00 – 21:00, Четверг 10:00 – 21:00, Пятница 10:00 – 21:00, Суббота 10:00 – 21:00, Воскресенье 10:00 – 21:00",
"46.349574, 48.033646");
INSERT INTO places (id, category_id, name, adress, time_work, position) VALUES (5, 2, "Дом Тетюшинова", "Коммунистическая улица, 26, Астрахань",
"Понедельник Выходной, Вторник 10:00 – 18:00, Среда 10:00 – 18:00, Четверг 13:00 – 21:00, Пятница 10:00 – 18:00, Суббота 10:00 – 18:00, Воскресенье 10:00 – 18:00",
"46.355016, 48.043779");
INSERT INTO places (id, category_id, name, url, adress, time_work, position) VALUES (6, 2, "Историко-архитектурный музей-заповедник", "https://astmuseum.ru/ru/", "Коммунистическая ул., 5/15, Астрахань",
"Понедельник Выходной, Вторник 10:00 – 17:00, Среда 10:00 – 17:00, Четверг 10:00 – 17:00, Пятница 10:00 – 19:00, Суббота 10:00 – 19:00, Воскресенье 10:00 – 17:00",
"46.349561, 48.041551");

INSERT INTO places (id, category_id, name, url, adress, time_work, position) VALUES (7, 3, "AZIMUT Сити Отель", "https://azimuthotels.com/ru/astrakhan/azimut-hotel-astrakhan?utm_content=main&utm_medium=link&utm_source=yasprav", "Кремлёвская улица, 4, Астрахань",
"Понедельник Круглосуточно, Вторник Круглосуточно, Среда Круглосуточно, Четверг Круглосуточно, Пятница Круглосуточно, Суббота Круглосуточно, Воскресенье Круглосуточно",
"46.348703, 48.020441");
INSERT INTO places (id, category_id, name, adress, time_work, position) VALUES (8, 3, "7 Небо", "Коммунистическая улица, 21/27, Астрахань",
"Понедельник Круглосуточно, Вторник Круглосуточно, Среда Круглосуточно, Четверг Круглосуточно, Пятница Круглосуточно, Суббота Круглосуточно, Воскресенье Круглосуточно",
"46.353915, 48.042773");
INSERT INTO places (id, category_id, name, url, adress, time_work, position) VALUES (9, 3, "Bonotel", "https://бон-отель.рф/", "улица Мусы Джалиля, 1, Астрахань",
"Понедельник Круглосуточно, Вторник Круглосуточно, Среда Круглосуточно, Четверг Круглосуточно, Пятница Круглосуточно, Суббота Круглосуточно, Воскресенье Круглосуточно",
"46.346961, 48.033188");

INSERT INTO tags_places (id, place_id, tag_id) VALUES (1, 1, 3);
INSERT INTO tags_places (id, place_id, tag_id) VALUES (2, 1, 12);
INSERT INTO tags_places (id, place_id, tag_id) VALUES (3, 1, 16);

INSERT INTO tags_places (id, place_id, tag_id) VALUES (4, 2, 4);
INSERT INTO tags_places (id, place_id, tag_id) VALUES (5, 2, 8);
INSERT INTO tags_places (id, place_id, tag_id) VALUES (6, 2, 13);

INSERT INTO tags_places (id, place_id, tag_id) VALUES (7, 3, 4);
INSERT INTO tags_places (id, place_id, tag_id) VALUES (8, 3, 8);
INSERT INTO tags_places (id, place_id, tag_id) VALUES (9, 3, 13);

INSERT INTO tags_places (id, place_id, tag_id) VALUES (10, 4, 1);
INSERT INTO tags_places (id, place_id, tag_id) VALUES (11, 4, 2);
INSERT INTO tags_places (id, place_id, tag_id) VALUES (12, 4, 8);

INSERT INTO tags_places (id, place_id, tag_id) VALUES (13, 5, 1);
INSERT INTO tags_places (id, place_id, tag_id) VALUES (14, 5, 2);
INSERT INTO tags_places (id, place_id, tag_id) VALUES (15, 5, 8);

INSERT INTO tags_places (id, place_id, tag_id) VALUES (16, 6, 1);
INSERT INTO tags_places (id, place_id, tag_id) VALUES (17, 6, 2);
INSERT INTO tags_places (id, place_id, tag_id) VALUES (18, 6, 8);

INSERT INTO tags_places (id, place_id, tag_id) VALUES (19, 7, 3);
INSERT INTO tags_places (id, place_id, tag_id) VALUES (20, 7, 7);

INSERT INTO tags_places (id, place_id, tag_id) VALUES (21, 8, 4);
INSERT INTO tags_places (id, place_id, tag_id) VALUES (22, 8, 8);

INSERT INTO tags_places (id, place_id, tag_id) VALUES (23, 9, 2);
INSERT INTO tags_places (id, place_id, tag_id) VALUES (24, 9, 3);
INSERT INTO tags_places (id, place_id, tag_id) VALUES (25, 9, 8);


INSERT INTO images (id, image, place_id) VALUES (1, "https://vizitastra.ru/wp-content/uploads/2019/10/IMG-9659.jpg", 1);
INSERT INTO images (id, image, place_id) VALUES (2, "https://i0.photo.2gis.com/images/branch/8/1125899943872538_e4da.jpg", 1);
INSERT INTO images (id, image, place_id) VALUES (3, "https://media-cdn.tripadvisor.com/media/photo-s/1b/b0/e4/e1/img-20200804-152100-largejpg.jpg", 1);

INSERT INTO images (id, image, place_id) VALUES (4, "https://rozmarin-astrakhan-esplanadnaya.restexpert.ru/photos/restaurant/59161/644x483/336078.jpg", 2);
INSERT INTO images (id, image, place_id) VALUES (5, "https://make-eat.ru/assets/cache_image/assets/gallery/206/1945_0x0_ed1.jpg", 2);

INSERT INTO images (id, image, place_id) VALUES (6, "https://i0.photo.2gis.com/images/branch/8/1125899952187433_1952.jpg", 3);
INSERT INTO images (id, image, place_id) VALUES (7, "https://avatars.mds.yandex.net/get-altay/4802381/2a0000017759d1421def08ff55e720c01de1/XXL", 3);

INSERT INTO images (id, image, place_id) VALUES (8, "https://top7travel.ru/wp-content/uploads/2022/08/98y9v8a90y80a8ya.jpg", 4);
INSERT INTO images (id, image, place_id) VALUES (9, "http://s1.fotokto.ru/photo/full/559/5596669.jpg", 4);

INSERT INTO images (id, image, place_id) VALUES (10, "https://astrakhanfm.ru/wp-content/uploads/2017/07/dom_kupca_tetyushinova.jpg", 5);
INSERT INTO images (id, image, place_id) VALUES (11, "https://i.pinimg.com/736x/90/b1/cc/90b1cc5205470d7b5c043798c0004d02.jpg", 5);

INSERT INTO images (id, image, place_id) VALUES (12, "https://img-fotki.yandex.ru/get/15537/51132524.62/0_ecea0_3928ef16_orig.jpg", 6);
INSERT INTO images (id, image, place_id) VALUES (13, "https://extraguide.ru/images/blog/2022/12-12-xu1gt0-kraevedcheskiy-muzey.jpg", 6);

INSERT INTO images (id, image, place_id) VALUES (14, "https://tsvto.ru/public/sites/pages/2753/235417.jpeg", 7);
INSERT INTO images (id, image, place_id) VALUES (15, "https://avatars.mds.yandex.net/get-altay/5476806/2a0000017d995cdae6dcc4313f85d43134ce/XXXL", 7);

INSERT INTO images (id, image, place_id) VALUES (16, "http://love-astrakhan.ru/img/100000014.jpg", 8);
INSERT INTO images (id, image, place_id) VALUES (17, "http://vetert.ru/rossiya/astrakhan/gostinica/116-otel-7-nebo/11.jpg", 8);

INSERT INTO images (id, image, place_id) VALUES (18, "http://photos.wikimapia.org/p/00/04/13/54/14_full.jpg", 9);
INSERT INTO images (id, image, place_id) VALUES (19, "https://avatars.mds.yandex.net/get-altay/1970665/2a000001877a0aa5e6f3a51f56320f2abe4b/orig", 9);