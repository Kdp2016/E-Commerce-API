create schema ecommerce;

set search_path to ecommerce;

CREATE TABLE user_roles (
    id int generated always as identity primary key,
    role_name varchar not null unique
);

CREATE TABLE users (
  id int generated always as identity primary key,
  first_name varchar NOT NULL,
  last_name varchar NOT NULL,
  email varchar unique NOT NULL,
  password varchar NOT NULL check(length(password) >= 7),
  role_id int default 1,
  
  constraint users_fk
  foreign key (role_id)
  references user_roles(id)
);

CREATE TABLE categories (
    id int generated always as identity primary key,
    category_name varchar not null unique
);

CREATE TABLE products (
    id int generated always as identity primary key,
    product_name varchar not null unique,
    product_description text not null,
    product_image varchar not null,
    brand varchar not null,
    price float not null,
    seller_id int not null,
    category_id int not null,
    created_at timestamp default current_timestamp,
    
    constraint products_seller_fk
    foreign key (seller_id)
    references users(id),

    constraint products_category_fk
    foreign key (category_id)
    references categories(id)
);

CREATE TABLE status (
    id int generated always as identity primary key,
    status_name varchar not null unique
);

CREATE TABLE orders (
    id int generated always as identity primary key,
    user_id int not null,
    product_id int not null,
    address varchar not null,
    order_date timestamp default current_timestamp,
    order_status_id int not null default 1,
    order_total float not null,
    
    constraint orders_user_fk
    foreign key (user_id)
    references users(id),

    constraint orders_product_fk
    foreign key (product_id)
    references products(id),

    constraint orders_status_fk
    foreign key (order_status_id)
    references status(id)
);

INSERT INTO user_roles (role_name) VALUES ('Buyer'), ('Seller'), ('Admin');
INSERT INTO users (first_name, last_name, email, password, role_id) VALUES ('Doug', 'McMillon', 'dougmcmillion@gmail.com', 'ilovewalmart', 2),
('Brian', 'Cornell', 'briancornell@gmail.com', 'ilovetarget', 2), 
('Jeremy', 'Bushay', 'jeremybushay@gmail.com', 'randompass', 1);
INSERT INTO categories (category_name) VALUES ('Electronics'), ('Clothing'), ('Books'), ('Movies'), ('Games'), ('Toys'), ('Home'), ('Sports'), ('Automotive'), ('Tools'), ('Health'), ('Beauty'), ('Garden'), ('Outdoors'), ('Pets'), ('Kids'), ('Food'), ('Fashion'), ('Grocery'), ('Misc');
INSERT INTO products (product_name, product_description, product_image, brand, price, seller_id, category_id) VALUES 
('Lenovo Legion 5i 15.6" Laptop', 'Offering a plethora of performance options for any gamer in a clean, minimalist design, the Lenovo Legion 5i pairs latest 10th Generation Intel® Core™ i5 H-Series processors, NVIDIA® GeForce RTX™ graphics, 2933 MHz DDR4 memory, M.2 NVMe PCIe SSD storage all thermally tuned via Legion Cold front 2.0. Enjoy maximum performance via Dual Burn Support, which pushes the CPU and GPU together for improved framerates. Further the Legion 5i combines blindingly fast refresh rates on a 100% color-accurate 1080p display with hair-trigger inputs via the Legion TrueStrike keyboard with soft-landing switches allowing you to scream past competition and rise the ranks.

2.5 GHz Intel Core i5-10500H Six-Core
8GB DDR4 RAM
256GB NVMe TLC SSD
15.6" 1920 x 1080 IPS Display
NVIDIA RTX 3050 4GB GPU', 'https://i5.walmartimages.com/asr/7522a6b8-bc19-4939-906e-5985b3d99098.41856c9e92934dd00a2797fb5b5031f0.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF', 'Walmart', 699.00, 1, 1), 
('Womens Anorak Jacket - Universal Thread™', 'Fit & style
Model wears size S and is 5''10"
Universal Thread anorak jacket is a great lightweight layering piece in your wardrobe
Breathable fabric with added stretch offers comfort and a flexible fit
Flap pockets let you keep essentials safe and close by while you''re on the go
Layers over anything from dresses to T-shirts for tons of outfit options
Available in extended sizes — Women''s and Women''s Plus', 'https://target.scene7.com/is/image/Target/GUEST_ba3eaaf2-70a1-4b7f-9c44-ac51e3c5450c?wid=2400&hei=2400&fmt=pjpeg', 'Target', 40.00, 2, 2);

INSERT INTO status (status_name) VALUES ('Ordered'), ('Delivered'), ('Cancelled');
INSERT INTO orders (user_id, product_id, address, order_status_id, order_total) VALUES (3, 1, '123 Main St', 1, 699.00), (3, 2, '123 Main St', 1, 40.00);
