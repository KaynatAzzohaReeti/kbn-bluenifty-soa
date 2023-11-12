-- ------ SALES ------

TRUNCATE TABLE categories;
TRUNCATE TABLE products;
TRUNCATE TABLE products_in_categories;

INSERT INTO categories VALUES
    ('1', 'books', 'E-Books'),
    ('2', 'games-toys', 'Frolics'),
    ('3', 'others', 'Miscellaneous');

INSERT INTO products VALUES
    ('1', 'Twelfth Fail', 'by Anurag Pathak', 45.00),
    ('2', 'Sunderkand', 'by Tulsidas Goswami', 35.00),
    ('3', 'Wish I Could', 'by Durjoy Datta', 32.50),
    ('4', 'Ludo', 'Classic family game', 3.20),
    ('5', 'Business with Coin', 'Assets Games Board Game', 11.50),
    ('6', 'Imperial Espresso', 'Coffee Maker', 85.00);

INSERT INTO products_in_categories VALUES
    ('1', '1'),
    ('2', '1'),
    ('3', '1'),
    ('4', '2'),
    ('5', '2'),
    ('6', '3');

-- ------ WAREHOUSE ------

TRUNCATE TABLE products_in_stock;

INSERT INTO products_in_stock VALUES
    ('1', 5),
    ('2', 0),
    ('3', 13),
    ('4', 55),
    ('5', 102),
    ('6', 1);