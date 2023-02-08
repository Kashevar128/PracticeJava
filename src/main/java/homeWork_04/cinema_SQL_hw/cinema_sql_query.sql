-- Запрос №0 - создание таблиц
CREATE TABLE IF NOT EXISTS film (
ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
name TEXT NOT NULL,
duration TIME NOT NULL
);

CREATE TABLE seans (
ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
start DATETIME NOT NULL,
price INTEGER NOT NULL,
film_id INTEGER NOT NULL,
FOREIGN KEY (film_id) REFERENCES film (ID)
);

CREATE TABLE bilet (
ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
seans_id INTEGER NOT NULL,
FOREIGN KEY (seans_id) REFERENCES seans (ID)
);

-- Запрос №1 ввод данных в таблицу film
INSERT INTO film VALUES (1, 'Убить Билла', '02:00:00'), (2, 'Властелин колец', '03:00:00'), (3, 'Кот в сапогах', '01:30:00'),
(4, 'Парад короткометражек', '01:00:00');
SELECT * FROM film;

-- Запрос №2 ввод данных в таблицу seans
INSERT INTO seans VALUES (1, '2023-02-02 08:00:00', 200, 1), (2, '2023-02-02 09:00:00', 200, 2), (3, '2023-02-02 12:30:00', 100, 3),
(4, '2023-02-02 15:00:00', 100, 4), (5, '2023-02-02 16:30:00', 400, 1), (6, '2023-02-02 19:00:00', 400, 2), (7, '2023-02-02 22:10:00', 250, 4);
UPDATE seans SET start = '2023-02-02 11:30:00' WHERE ID = 3;
SELECT * FROM seans;

-- Запрос №3 ввод данных в таблицу bilet
INSERT INTO bilet VALUES (1, 1), (2, 1), (3, 1), (4, 1), (5, 2), (6, 2), (7, 2), (8, 2), (9, 2), (10, 2), (11, 2), (12, 3), (13, 3), (14, 3),
(15, 4), (16, 4), (17, 5), (18, 5), (19, 6), (20, 6), (21, 7), (22, 7);
SELECT * FROM bilet;

/*Запрос №4
ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию
времени. Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время
начала», «длительность»;
*/
SELECT f.name, s.start, f.duration, f2.name, s2.start, f2.duration
FROM seans s
INNER JOIN film f ON s.film_id = f.ID
INNER JOIN seans s2 ON s2.start > s.start and  s2.start < date_add(s.start, interval f.duration HOUR_SECOND)
INNER JOIN film f2 ON s2.film_id = f2.ID
ORDER BY s.start ASC;

/*Запрос №5
перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность
перерыва»;
*/
select
(select film.name from film where film.ID = s1.film_id) as nameFilm,
min(s1.start) as 'session start',
min(f1.duration) as 'duration',
min(s2.start) as 'start of the next session',
timediff( min(s2.start), date_add(s1.start, interval f1.duration HOUR_SECOND) ) as break
from seans s1
join film f1 on s1.film_id = f1.id
left join seans s2 on s1.start < s2.start
group by s1.ID
HAVING time_to_sec(break) >= 60 * 30
ORDER BY break DESC;

/*Запрос №6
список фильмов, для каждого — с указанием общего числа посетителей за все время, среднего числа
зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию
прибыли). Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам
сразу;
*/
(select f.name , count(*) as 'total number of tickets',
count(*) / count(distinct b.seans_id) as avgBuyed,
sum(s.price) as total_price_film
from seans s
join bilet b on s.ID = b.seans_id
join film f on s.film_id = f.ID
group by s.film_id
order by total_price_film desc)
union select "Итого", count(*), count(b.seans_id) / count(distinct b.seans_id), sum(s.price)
from seans s
join bilet b on s.id = b.seans_id;

/*Запрос №7
число посетителей и кассовые сборы, сгруппированные по времени начала фильма: с 9 до 15, с 15 до
18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.).
*/
select hour(min(s.start)),  sum(price), count(*)
from seans s
join bilet b on s.id = b.seans_id
group by
(hour(s.start) >= 9 and hour(s.start) < 15),
(hour(s.start) >= 15 and hour(s.start) < 18),
(hour(s.start) >= 18 and hour(s.start) < 21),
(hour(s.start) >= 21 and hour(s.start) < 00)







