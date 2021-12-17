--Funcionarios
    --Tratadores

insert into funcionarios values('Joaquim Silva','2003/2/1',266787809,919999999,'Tratador',123123123);
insert into funcionarios values('Manuel Santos','2003/4/1',266787808,919999998,'Tratador',123123124);
insert into funcionarios values('Maria Gomes','2003/1/1',266787807,919999997,'Tratador', 123123125);
    --Tratador Auxiliar
insert into funcionarios values('Mariana Silva','2004/2/1',266878806,919999996,'Tratador Auxiliar',123123126);
insert into funcionarios values('Jorge Gomes','2004/3/1',266787807,919999995,'Tratador Auxiliar',123123127);
insert into funcionarios values('Francisco Jorge','2004/3/1',266787806,919999994,'Tratador Auxiliar',123123128);
    --Administrativos
insert into funcionarios values('Manuel Ferreira','2004/2/1',266787806,919999996,'Administrativo',123123129);
insert into funcionarios values('Manuela Torres','2004/4/1',266787806,919999996,'Administrativo',123123130);
    --Veterinários
insert into funcionarios values('Pedro Vale','2004/5/1',266787816,919999986,'Veterinário',123123131);
insert into funcionarios values('Isabel Soares','2004/6/1',266787826,919999976,'Veterinário',123123132);
-- Responsavel

insert INTO responsavel values(123123125,123123123);
insert INTO responsavel values(123123125,123123124);
insert INTO responsavel values(123123130,123123125);
insert INTO responsavel values(123123130,123123126);
insert INTO responsavel values(123123130,123123127);
insert INTO responsavel values(123123130,123123128);
insert INTO responsavel values(123123130,123123129);
insert INTO responsavel values(123123129,123123130);
insert INTO responsavel values(123123129,123123131);
insert INTO responsavel values(123123131,123123132);
--Tratador

insert into tratadores values(123123123,123456);
insert into tratadores values(123123123,222456);
insert into tratadores values(123123123,322456);
insert into tratadores values(123123123,422456);
insert into tratadores values(123123123,432456);
insert into tratadores values(123123123,522456);
insert into tratadores values(123123123,622456);
insert into tratadores values(123123124,123444);
insert into tratadores values(123123124,223444);
insert into tratadores values(123123124,323444);
insert into tratadores values(123123124,123666);
insert into tratadores values(123123124,223666);
insert into tratadores values(123123124,323666);
insert into tratadores values(123123124,423666);
insert into tratadores values(123123124,524666);
insert into tratadores values(123123125,123555);
insert into tratadores values(123123125,133555);
insert into tratadores values(123123125,223555);
insert into tratadores values(123123125,323555);
insert into tratadores values(123123125,523555);
insert into tratadores values(123123125,523555);

--Tratadores auxiliares 

insert into tratadores_auxiliares values(123123126,'A3');
insert into tratadores_auxiliares values(123123126,'A4');
insert into tratadores_auxiliares values(123123126,'A5');
insert into tratadores_auxiliares values(123123127,'A1');
insert into tratadores_auxiliares values(123123128,'A2');
insert into tratadores_auxiliares values(123123128,'A5');

--Consultas

insert into consultas values(123123131,222456,'2005/8/12','grávida','A3');
insert into consultas values(123123131,222456,'2005/9/12','cálcio injetado','A3');
insert into consultas values(123123131,222456,'2005/12/12','parto','A3');
insert into consultas values(123123131,222456,'2006/7/12','infecção','A3');
insert into consultas values(123123131,222456,'2006/7/12','antibiótico injectado','A3');
insert into consultas values(123123131,123666,'2009/5/12','infecção','A2');
insert into consultas values(123123131,123666,'2009/5/12','antibiótico injectado','A2');
insert into consultas values(123123131,123555,'2009/5/12','infecção','A5');
insert into consultas values(123123131,123555,'2009/5/12','antibiótico injectado','A5');
insert into consultas values(123123131,423555,'2009/5/12','infecção','A5');
insert into consultas values(123123131,423555,'2009/5/12','antibiótico injectado','A5');
insert into consultas values(123123131,223444,'2007/8/12','infecção','A1');
insert into consultas values(123123131,223444,'2007/8/12','antibiótico injectado ','A1');

insert into consultas values(123123132,223444,'2006/7/12','grávida','A1');
insert into consultas values(123123132,223444,'2006/7/12','cálcio injectado','A1');
insert into consultas values(123123132,223444,'2006/9/12','parto','A1');
insert into consultas values(123123132,223444,'2007/7/12','infecção','A1');
insert into consultas values(123123132,223444,'2007/7/12','antibiótico injectado','A1');
insert into consultas values(123123132,223444,'2007/7/12','grávida','A1');
insert into consultas values(123123132,223444,'2007/7/12','cálcio injectado','A1');
insert into consultas values(123123132,223444,'2007/9/12','parto','A1');
insert into consultas values(123123132,423555,'2009/6/12','infecção','A5');
insert into consultas values(123123132,423555,'2009/6/12','antibiótico injectado','A5');