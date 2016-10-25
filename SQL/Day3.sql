/* Q1 */ SELECT name FROM sakila.language ORDER BY name;

/* Q2 */ SELECT first_name, last_name FROM sakila.actor WHERE last_name LIKE '%SON' ORDER BY first_name;

/* Q3 */ SELECT address FROM sakila.address WHERE district LIKE '' ORDER BY city_id ASC;

/* Q4 */ SELECT title, category.name FROM sakila.film INNER JOIN sakila.film_category ON film.film_id=film_category.film_id
INNER JOIN sakila.category ON film_category.category_id=category.category_id ORDER BY title;

/* Q5 */ SELECT category_id, COUNT(category_id) AS a FROM sakila.film_category GROUP BY category_id ORDER BY a;

/* Q6 */ SELECT category_id, COUNT(category_id) AS a FROM sakila.film_category GROUP BY category_id HAVING a>60 ORDER BY a;

/* Q7 */ SELECT category_id, AVG(replacement_cost - rental_rate) AS dif FROM sakila.film_category INNER JOIN sakila.film 
ON film_category.film_id=film.film_id GROUP BY category_id HAVING dif > 17;

/* Q8 not working */ SELECT title, category.name AS category INTO filmcategory FROM film INNER JOIN film_category 
ON film.film_id=film_category.film_id INNER JOIN category ON filmcategorylm_category.category_id=category.category_id;

/* Q9 */ SELECT name, AVG(replacement_cost - rental_rate) AS dif FROM sakila.film_category INNER JOIN sakila.film 
ON film_category.film_id=film.film_id INNER JOIN sakila.category ON film_category.category_id=category.category_id 
GROUP BY category.category_id HAVING dif > 17;

/* Q10 */ SELECT actor.actor_id, first_name, last_name, COUNT(film_actor.actor_id) AS films FROM sakila.actor INNER JOIN sakila.film_actor
ON actor.actor_id=film_actor.actor_id GROUP BY film_actor.actor_id ORDER BY films;

/* Q11 */ SELECT actor.actor_id, first_name, last_name, COUNT(film_actor.actor_id) AS films FROM (SELECT * FROM sakila.film WHERE length > 183) AS a 
INNER JOIN sakila.film_actor ON a.film_id=film_actor.film_id 
INNER JOIN sakila.actor ON film_actor.actor_id=actor.actor_id GROUP BY film_actor.actor_id ORDER BY films;

/* Q12 */ SELECT title FROM sakila.film INNER JOIN sakila.film_category ON film.film_id=film_category.film_id INNER JOIN sakila.category 
ON film_category.category_id=category.category_id INNER JOIN sakila.language ON film.language_id=language.language_id 
WHERE language.name = 'English' and category.name = 'Documentary';
/* or */ SELECT title FROM sakila.film INNER JOIN sakila.film_category ON film.film_id=film_category.film_id 
WHERE film.language_id = 1 and film_category.category_id = 6;

/* Q13 */ SELECT film.film_id, title from sakila.film LEFT JOIN sakila.inventory ON film.film_id=inventory.film_id WHERE inventory.film_id IS NULL; 
/* or */ SELECT film.film_id, title from sakila.film WHERE film_id NOT IN (SELECT inventory.film_id FROM sakila.inventory);

/* Q14 */ 