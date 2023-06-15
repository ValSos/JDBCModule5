SELECT client.name, count(project.id) AS project_count
FROM client 
JOIN project ON client.id = project.client_id
GROUP BY client.name
HAVING project_count IN (
	SELECT MAX(project_count) 
	FROM (
		SELECT count(id) AS project_count 
		FROM project 
		GROUP BY client_id
	)
);