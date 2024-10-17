create table if not exists users(
    id bigint generated always as identity unique primary key,
    name text
);