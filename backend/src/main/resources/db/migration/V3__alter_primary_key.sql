-- S'assurer que l'extension existe
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

-- Modifier la colonne id pour générer l'UUID automatiquement
ALTER TABLE slots
ALTER COLUMN id SET DEFAULT gen_random_uuid();