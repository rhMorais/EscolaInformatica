insert into escolaInformatica.professor (nome)
	values  ('João Santos'),
			('Maria das Graças'),
            ('Etelvina Soares');

insert into escolaInformatica.materia (descricao, id_professor)
	values  ('Word', 1),
			('Excel', 2),
            ('Power Point', 3),
            ('Navegação na Internet', 1),
            ('PhotoShop', 3),
            ('Excel Avançado', 2);

insert into escolaInformatica.curso (descricao)
	values	('Informatica Básica');

insert into escolaInformatica.materia_cursos (id_curso, id_materia)
	values	(1, 1),
			(1, 2),
            (1, 3),
            (1, 4),
            (1, 5);

insert into escolaInformatica.aluno (cpf, data_nascimento, nome)
	values 	(12345678912, '20000526', 'Jeronimo Cândido'),
			(98765432198, '20010405', 'Emiliano Alves'),
            (45678912345, '20030628', 'Maria Cacilda'),
            (78945612378, '19990823', 'Antônia Silva'),
            (32165498732, '19980713', 'Visconde Albertino'),
            (65489732165, '19970912', 'Aloísio Miguel'),
            (15945675315, '20021115', 'Jessica Maria');

insert into escolaInformatica.turma (periodo, id_curso)
	values	('Manhã', 1);

insert into escolaInformatica.aluno_turmas (id_turma, id_aluno)
	values	(1, 1),
			(1, 2),
            (1, 3),
            (1, 4);
