
select 
    mo.chr_cuencodigo cuenta,
    mo.int_movinumero nuomov,
    to_char(mo.dtt_movifecha,'DD/MM/YYYY') fecha,
    tm.vch_tipodescripcion tipo,
    mo.dec_moviimporte importe
from tipomovimiento tm
join movimiento mo on tm.chr_tipocodigo = mo.chr_tipocodigo;

select to_char(sysdate,'DD/MM/YYYY') from dual;


select 
    su.chr_sucucodigo codigo,
    su.vch_sucunombre nombre,
    sum(case when cu.chr_monecodigo = '01' then cu.dec_cuensaldo else 0 end) soles,
    sum(case when cu.chr_monecodigo = '02' then cu.dec_cuensaldo else 0 end) dolares
from sucursal su 
join cuenta cu on su.chr_sucucodigo = cu.chr_sucucodigo
group by su.chr_sucucodigo, su.vch_sucunombre;

