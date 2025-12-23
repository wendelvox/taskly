INSERT INTO public.usr_usuario(
	usr_id_usuario, usr_ds_login, usr_ds_email, usr_ds_nome, usr_ds_senha)
	VALUES (1, 'wendelvox', 'wendelvoxs@gmail.com', 'Wendel', '123456');

	alter sequence usr_usuario_seq restart with 2;

	INSERT INTO public.pfl_perfil(
	pfl_id_perfil, pfl_des_descricao)
	VALUES (1, 'Administrador');

	alter sequence pfl_perfil_seq restart with 2;