
create or replace procedure usp_egcc_saldo_cuenta
( p_cuenta varchar2, p_saldo out number )
is
begin
    select dec_cuensaldo into p_saldo
    from cuenta
    where chr_cuencodigo = p_cuenta;
end;
/



set serveroutput on

declare
    v_saldo number;
begin
    usp_egcc_saldo_cuenta('00100001',v_saldo);
    dbms_output.put_line('Saldo: ' || v_saldo);
end;
/



