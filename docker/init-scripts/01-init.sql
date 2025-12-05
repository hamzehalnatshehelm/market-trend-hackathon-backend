-- Create a single database for all microservices
CREATE DATABASE microservices_db;

-- Connect to the database
\c microservices_db;

-- ============================================================================
-- CREATE SCHEMAS
-- ============================================================================

-- Schema for user-management service
CREATE SCHEMA user_management;

-- Schema for payment service
CREATE SCHEMA payment;

-- ============================================================================
-- CREATE USERS
-- ============================================================================

-- Create user for user-management service
CREATE USER user_service WITH PASSWORD 'user_service_password';

-- Create user for payment service
CREATE USER payment_service WITH PASSWORD 'payment_service_password';

-- ============================================================================
-- GRANT PERMISSIONS
-- ============================================================================

-- Grant all privileges on user_management schema to user_service
GRANT ALL ON SCHEMA user_management TO user_service;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA user_management TO user_service;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA user_management TO user_service;
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA user_management TO user_service;

-- Set default privileges for future objects in user_management schema
ALTER DEFAULT PRIVILEGES IN SCHEMA user_management
    GRANT ALL ON TABLES TO user_service;
ALTER DEFAULT PRIVILEGES IN SCHEMA user_management
    GRANT ALL ON SEQUENCES TO user_service;
ALTER DEFAULT PRIVILEGES IN SCHEMA user_management
    GRANT ALL ON FUNCTIONS TO user_service;

-- Set search path for user_service
ALTER USER user_service SET search_path TO user_management, public;

-- Grant all privileges on payment schema to payment_service
GRANT ALL ON SCHEMA payment TO payment_service;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA payment TO payment_service;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA payment TO payment_service;
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA payment TO payment_service;

-- Set default privileges for future objects in payment schema
ALTER DEFAULT PRIVILEGES IN SCHEMA payment
    GRANT ALL ON TABLES TO payment_service;
ALTER DEFAULT PRIVILEGES IN SCHEMA payment
    GRANT ALL ON SEQUENCES TO payment_service;
ALTER DEFAULT PRIVILEGES IN SCHEMA payment
    GRANT ALL ON FUNCTIONS TO payment_service;

-- Set search path for payment_service
ALTER USER payment_service SET search_path TO payment, public;

-- ============================================================================
-- OPTIONAL: Grant USAGE on public schema (if needed)
-- ============================================================================
GRANT USAGE ON SCHEMA public TO user_service;
GRANT USAGE ON SCHEMA public TO payment_service;
