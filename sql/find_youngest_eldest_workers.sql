SELECT 'Youngest' type, name, birthday
FROM worker
WHERE birthday IN (
  SELECT MAX(birthday)
  FROM worker
)
UNION
SELECT 'Eldest' type, name, birthday
FROM worker
WHERE birthday IN (
  SELECT MIN(birthday)
  FROM worker
);