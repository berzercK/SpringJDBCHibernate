# 2. Создать запросы для вывода:
# a) всех различных названий и стоимостей книг;
SELECT distinct name, price
FROM books;

# b) всех различных районов, в которых проживают покупатели;
SELECT distinct region
FROM buyers;

# c) поиск всех различных месяцев, когда производились покупки.
SELECT distinct DATE_FORMAT(date, '%m-%Y') as dateColumn
FROM purchase;

# 3. Создать запросы для получения информации о:

# c)	Названиях  и стоимости книг, в которых встречается слово Windows, или стоящих более 20000 руб. Вывод результатов организовать по названию и убыванию цены книг.
select name, price
from Books
where name like "%Windows"
   or price > 20000
order by price desc;

# 4. Для каждой покупки вывести:
# a. фамилию покупателя и название магазина, где производилась покупка;
SELECT buyers.name as BuyerFamily,
       shop.name   as ShopName
FROM purchase
       left join buyers on (buyers.id_buyer = purchase.buyer)
       left join shop on (shop.id_shop = purchase.shop);

# b.	дату, фамилию покупателя, скидку, название и количество купленных книг.
SELECT purchase.date as Date,
       buyers.name   as BuyerFamily,
       buyers.sale   as BuyerSale,
       books.name    as BookName,
       purchase.qty  as CountBooks
FROM purchase
       left join buyers on (buyers.id_buyer = purchase.buyer)
       left join books on (books.id_book = purchase.shop);
