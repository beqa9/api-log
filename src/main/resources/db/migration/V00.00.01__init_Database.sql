CREATE TABLE IF NOT EXISTS api_logs (
    id BIGSERIAL PRIMARY KEY,
    endpoint VARCHAR(512) NOT NULL,
    http_method VARCHAR(10) NOT NULL DEFAULT 'GET',
    request_params JSONB,
    response_body JSONB,
    status_code INT,
    execution_time_ms INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);