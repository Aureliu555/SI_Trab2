create or replace function f_opt_lock() returns trigger
language plpgsql as $$

declare c int;
begin
	if new.vrs = old.vrs then
	new.vrs = new.vrs + 1;
	end if;
return new;
end; $$;

CREATE or replace TRIGGER GL_Opt
BEFORE insert or UPDATE on alarme
FOR EACH ROW
execute function f_opt_lock();

CREATE or replace TRIGGER GL_Opt
BEFORE insert or UPDATE on cliente
FOR EACH ROW
execute function f_opt_lock();

CREATE or replace TRIGGER GL_Opt
BEFORE insert or UPDATE on clienteinstitucional
FOR EACH ROW
execute function f_opt_lock();

CREATE or replace TRIGGER GL_Opt
BEFORE insert or UPDATE on clienteparticular
FOR EACH ROW
execute function f_opt_lock();

CREATE or replace TRIGGER GL_Opt
BEFORE insert or UPDATE on gps
FOR EACH ROW
execute function f_opt_lock();

CREATE or replace TRIGGER GL_Opt
BEFORE insert or UPDATE on invalido
FOR EACH ROW
execute function f_opt_lock();

CREATE or replace TRIGGER GL_Opt
BEFORE insert or UPDATE on processado
FOR EACH ROW
execute function f_opt_lock();

CREATE or replace TRIGGER GL_Opt
BEFORE insert or UPDATE on alarme
FOR EACH ROW
execute function f_opt_lock();

CREATE or replace TRIGGER GL_Opt
BEFORE insert or UPDATE on registonprocessado
FOR EACH ROW
execute function f_opt_lock();

CREATE or replace TRIGGER GL_Opt
BEFORE insert or UPDATE on veiculo
FOR EACH ROW
execute function f_opt_lock();

CREATE or replace TRIGGER GL_Opt
BEFORE insert or UPDATE on zonaverde
FOR EACH ROW
execute function f_opt_lock();