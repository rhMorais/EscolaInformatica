select *
	from escolaInformatica.professor;

select *
	from escolaInformatica.materia;
    
select *
	from escolaInformatica.aluno;    

select *
	from escolaInformatica.curso;

select *
	from escolaInformatica.materia_cursos;


insert into escolaInformatica.professor(nome)
	values  ('João Santos'),
			('Maria das Graças'),
            ('Etelvina Soares');
            
insert into escolaInformatica.materia(descricao, id_professor)
	values  ('Word', 1),
			('Excel', 2),
            ('Power Point', 3),
            ('Navegação na Internet', 1),
            ('PhotoShop', 3),
            ('Excel Avançado', 2);
            
insert into escolaInformatica.curso(descricao)            
	values	('curso teste');
            
insert into escolaInformatica.materia_cursos(materias_id, cursos_id)
	values	(2, 1);
