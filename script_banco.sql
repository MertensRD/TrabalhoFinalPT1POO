-- 1. (Schema)
CREATE DATABASE IF NOT EXISTS sistema_academico;

-- 2. Banco de dados para uso
USE sistema_academico;

-- 3. Tabela de Alunos
CREATE TABLE IF NOT EXISTS alunos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    rga VARCHAR(50) NOT NULL,
    email VARCHAR(150) NOT NULL,
    curso VARCHAR(100) NOT NULL
);
-- 4. Tabela de Professores
CREATE TABLE IF NOT EXISTS professores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    siape VARCHAR(50) NOT NULL,
    unidade_academica VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL
);