CREATE DATABASE IF NOT EXISTS murimwars
  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE murimwars;

CREATE TABLE IF NOT EXISTS productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    sku VARCHAR(40) NOT NULL UNIQUE,
    categoria VARCHAR(60) NOT NULL,
    talla VARCHAR(20),
    precio DECIMAL(12,2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    descripcion VARCHAR(500)
);

-- Datos iniciales de demostración. Los SKU deben ser únicos.
INSERT INTO productos (nombre, sku, categoria, talla, precio, stock, descripcion)
SELECT 'Jean Murim edición urbana', 'MW-JEAN-001', 'Jeans', '32', 90000, 8,
       'Jean urbano personalizable de la colección Murim Wars'
WHERE NOT EXISTS (SELECT 1 FROM productos WHERE sku = 'MW-JEAN-001');
