-- This script runs automatically against the database defined in POSTGRES_DB (market_trends_db)

-- ============================================================================
-- CREATE SCHEMAS
-- ============================================================================

-- If the schema doesn't exist, create it (idempotent)
CREATE SCHEMA IF NOT EXISTS user_management;
CREATE SCHEMA IF NOT EXISTS payment;
CREATE SCHEMA IF NOT EXISTS market_trends;

-- ============================================================================
-- CREATE USERS (Using IF NOT EXISTS for safety)
-- ============================================================================

-- Create user for user-management service
CREATE USER user_management_user WITH PASSWORD 'password';

-- Create user for payment service
CREATE USER payment_user WITH PASSWORD 'password';

-- Create user for market_trends service
CREATE USER market_trends_user WITH PASSWORD 'password';

-- ============================================================================
-- GRANT PERMISSIONS
-- ============================================================================

-- 1. user_management
GRANT ALL ON SCHEMA user_management TO user_management_user;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA user_management TO user_management_user;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA user_management TO user_management_user;
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA user_management TO user_management_user;

ALTER DEFAULT PRIVILEGES IN SCHEMA user_management
    GRANT ALL ON TABLES TO user_management_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA user_management
    GRANT ALL ON SEQUENCES TO user_management_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA user_management
    GRANT ALL ON FUNCTIONS TO user_management_user;

ALTER USER user_management_user SET search_path TO user_management, public;


-- 2. payment
GRANT ALL ON SCHEMA payment TO payment_user;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA payment TO payment_user;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA payment TO payment_user;
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA payment TO payment_user;

ALTER DEFAULT PRIVILEGES IN SCHEMA payment
    GRANT ALL ON TABLES TO payment_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA payment
    GRANT ALL ON SEQUENCES TO payment_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA payment
    GRANT ALL ON FUNCTIONS TO payment_user;

ALTER USER payment_user SET search_path TO payment, public;


-- 3. market_trends (CORRECTED)
-- Grant USAGE on the schema itself (required to access objects)
GRANT USAGE ON SCHEMA market_trends TO market_trends_user;

-- Grant ALL on the schema (required for creating objects)
GRANT ALL ON SCHEMA market_trends TO market_trends_user;

-- NOTE: Ensure ALL PRIVILEGES grants are on the correct schema (market_trends)
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA market_trends TO market_trends_user;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA market_trends TO market_trends_user;
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA market_trends TO market_trends_user;

ALTER DEFAULT PRIVILEGES IN SCHEMA market_trends
    GRANT ALL ON TABLES TO market_trends_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA market_trends
    GRANT ALL ON SEQUENCES TO market_trends_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA market_trends
    GRANT ALL ON FUNCTIONS TO market_trends_user;

ALTER USER market_trends_user SET search_path TO market_trends, public;


-- OPTIONAL: Grant USAGE on public schema (if needed)
GRANT USAGE ON SCHEMA public TO user_management_user;
GRANT USAGE ON SCHEMA public TO payment_user;
GRANT USAGE ON SCHEMA public TO market_trends_user;
