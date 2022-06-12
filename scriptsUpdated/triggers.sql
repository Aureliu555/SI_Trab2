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

