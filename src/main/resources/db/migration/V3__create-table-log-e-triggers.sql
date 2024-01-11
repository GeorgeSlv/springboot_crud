--Criação da tabela

CREATE TABLE tb_log (
	id serial4 NOT NULL,
	cpf varchar(14) NULL,
	data_criacao date NULL,
	data_alteracao date NULL,
	CONSTRAINT tb_log_pkey PRIMARY KEY (id)
);

--Funções para as triggers

CREATE OR REPLACE FUNCTION public.log_insert()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
BEGIN
    INSERT INTO tb_log (cpf, data_criacao, data_alteracao)
    VALUES (NEW.cpf, current_timestamp, current_timestamp);
    
    RETURN NEW;
END;
$function$
;

CREATE OR REPLACE FUNCTION public.log_update()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
BEGIN
    UPDATE tb_log
    SET data_alteracao = current_timestamp
    WHERE cpf = NEW.cpf;
    
    RETURN NEW;
END;
$function$
;

-- Triggers

CREATE TRIGGER trigger_log_insert
AFTER INSERT ON proprietarios
FOR EACH ROW
EXECUTE FUNCTION log_insert();

CREATE TRIGGER trigger_log_update
AFTER UPDATE ON proprietarios
FOR EACH ROW
EXECUTE FUNCTION log_update();

