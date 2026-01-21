ALTER TABLE slots
ADD COLUMN end_time TIMESTAMP;

UPDATE slots
SET end_time = start_time + INTERVAL '1 hour';

ALTER TABLE slots
ALTER COLUMN end_time SET NOT NULL;
