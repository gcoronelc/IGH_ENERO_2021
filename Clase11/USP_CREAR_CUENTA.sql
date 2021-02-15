USE EUREKABANK;
GO

DROP PROCEDURE USP_CREAR_CUENTA;
GO


CREATE PROCEDURE USP_CREAR_CUENTA
(
	@CodCliente  varchar(10),
	@CodMoneda   varchar(10),
	@CodSucursal varchar(10),
	@CodEmpleado varchar(10),
	@Importe     numeric(10,2),
	@Clave       varchar(20),
	@Cuenta      varchar(20) out,
	@codigo      int out,
	@mensaje     varchar(1000) out
)
AS
BEGIN
	declare  @contador int;
	BEGIN TRY
		-- Inicio de transacción
		BEGIN TRANSACTION;
		-- Generar numero de cuenta
		select @contador = int_sucucontcuenta 
		from sucursal
		where chr_sucucodigo = @codSucursal;
		if( @@ROWCOUNT = 0 )
		begin
			throw 51000, 'Sucursal no existe.', 1;
		end;
		set @contador = @Contador + 1;
		update sucursal
		set int_sucucontcuenta = @contador
		where chr_sucucodigo = @codSucursal;
		set @Cuenta = @CodSucursal + RIGHT( '00000' + cast(@contador as varchar(10)), 5 );
		print @Cuenta;
		-- Registrar la cuenta
		insert into cuenta(chr_cuencodigo,chr_monecodigo,chr_sucucodigo,chr_emplcreacuenta,
		chr_cliecodigo,dec_cuensaldo,dtt_cuenfechacreacion,vch_cuenestado,int_cuencontmov,
		chr_cuenclave)
		values(@Cuenta,@CodMoneda,@CodSucursal,@CodEmpleado,@CodCliente,@Importe,GETDATE(),
		'ACTIVO',1,@Clave);
		-- Registrar el movimiento
		insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,chr_emplcodigo,
		chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
		values(@Cuenta,1,GETDATE(),@CodEmpleado,'001',@Importe,null);
		-- Fin de transacción
		set @codigo = 1;
		set @mensaje = 'Proceso ejecutado correctamente.';
		COMMIT TRANSACTION;
	END TRY
	BEGIN CATCH
		ROLLBACK TRANSACTION;
		set @codigo = -1;
		set @mensaje = 'Proceso fue abortado.';
	END CATCH;
END;
GO

begin
	declare @codigo int, @mensaje varchar(2000), @Cuenta varchar(10);
	EXEC USP_CREAR_CUENTA '00005', '02', '005', '0006', 5000.0, '123456', @Cuenta out, @codigo out, @mensaje out;
	print cast(@codigo as varchar(10)) + ' - ' + @mensaje;
	print 'Cuenta creada: ' + @Cuenta;
end;
go

select * from cliente;
go

select * from dbo.cuenta;
go

select * from dbo.sucursal;
go

select * from dbo.movimiento;
go

select RIGHT('2345678',3);
go

sp_help cuenta;
go

sp_help movimiento;
go

select GETDATE();
go

select * from TipoMovimiento;
go

