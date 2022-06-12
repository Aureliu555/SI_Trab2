------------------------------------------------------------------------------------------------------------
---------------------------------------- optimistic locking trigger ----------------------------------------

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


---------------------------------------------------------------------------------------------------
---------------------------------------- registers trigger ----------------------------------------

create or replace trigger trigger_processado_insertion
after insert on processado
    for each row
execute procedure generate_alarme();


---------------------------------------------------------------------------------------------------------------
---------------------------------------- update vehicle alarms trigger ----------------------------------------

create or replace trigger trigger_update_vehicle_alarms
after insert on alarme
    for each row
execute procedure update_vehicleAlarms();

