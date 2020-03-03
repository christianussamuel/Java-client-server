SELECT o.ts,p.name,p.price,c.name,c.address
FROM product_order AS o
LEFT JOIN customer AS c ON o.customer_id=c.customer_id
LEFT JOIN product AS p ON o.product_id=p.product_id