INSERT INTO agentes (cod_agen, n_agen, espe, tp_ayuda, agen_dir)
VALUES  (0, 'Agente1', 'Desconocido', 'Desconocido', 0),
        (1, 'Juan Pérez', 'Inteligencia militar', 'Financiera', 0),
        (2, 'Ana García', 'Técnicas de infiltración', 'Logística', 1),
        (3, 'Carlos Ramírez', 'Armas y combate', 'Sanitaria', 2),
        (4, 'María Sánchez', 'Interrogatorios', 'Técnica', 1),
        (5, 'Luis Torres', 'Ingeniería', 'Inteligencia', 4),
        (6, 'Ricardo Flores', 'Comunicaciones', 'Logística', 1),
        (7, 'Laura Hernández', 'Medicina', 'Sanitaria', 6),
        (8, 'Jorge Mendoza', 'Tiro de precisión', 'Inteligencia', 2),
        (9, 'Fernando Díaz', 'Manejo de explosivos', 'Logística', 3),
        (10, 'Mónica Torres', 'Disuasión', 'Técnica', 7),
        (14, '14', '14', '14', 8);

INSERT INTO capacidad (cod_cap, tp_cap)
VALUES  (1, 'Capacidad Destructiva BAJA'),
        (2, 'Capacidad Destructiva MEDIA'),
        (3, 'Capacidad Destructiva ALTA');

INSERT INTO equipo (cod_eq, n_eq)
VALUES  (1, 'Mandroides'),
        (2, 'Autos Voladores'),
        (3, 'SDVs'),
        (4, 'Helitransporte');

INSERT INTO grupo_sh (cod_gp_sp, n_gp)
VALUES  (1, 'The Avengers'),
        (2, 'Los 4 fantásticos'),
        (3, 'X-Men');

INSERT INTO paises (cod_pais, n_pais)
VALUES  ('USA ', 'Estados Unidos'),
        ('AUT ', 'Austria'),
        ('VNM ', 'Vietnam');

INSERT INTO tp_alien (cod_alien, raza_alien)
VALUES  (1, 'Asgardianos'),
        (2, 'Asgardianos oscuros'),
        (3, 'Chitauri'),
        (4, 'Chronicoms'),
        (5, 'Chronyca-2'),
        (6, 'Drednocks'),
        (7, 'Kree'),
        (8, 'Graviton'),
        (9, 'Inhumanos'),
        (10, 'Leviatán'),
        (11, 'Los monolitos'),
        (12, 'Vrellnexianos'),
        (13, 'Marauders'),
        (14, 'Mavethianos'),
        (15, 'Sakaaranos'),
        (16, 'Shrike'),
        (17, 'Watchdogs');

INSERT INTO ataque (cod_atk, n_atk, nro_bajas, nro_heridos, pais_atk)
VALUES  (1, 'Ataque al Hub de S.H.I.E.L.D.', 17, 87, 'USA '),
        (2, 'Ataque a la Academia S.H.I.E.L.D.', 39, 25, 'USA '),
        (4, 'Asalto a la Base de Inhumans', 8, 43, 'USA '),
        (3, 'Asalto al Agente Triple', 54, 69, 'AUT '),
        (5, 'Ataque al Centro de Operaciones de ATCU', 92, 52, 'VNM ');

INSERT INTO lider (cod_lider, cod_gp_sh, n_lider)
VALUES  (1, 1, 'Nick Fury'),
        (2, 1, 'Maria Hill'),
        (3, 1, 'Phil Coulson'),
        (4, 2, 'General Ross'),
        (5, 3, 'Profesor X'),
        (6, 3, 'Cíclope'),
        (7, 3, 'Tormenta');

INSERT INTO director (cod_dir, n_dir, rango_dir, lider)
VALUES  (1, 'Daisy Johnson', 'Alto', 1),
        (2, 'Sharon Carter', 'Alto', 3),
        (3, 'Leo Fitz', 'Alto', 1),
        (4, 'Alphonso Mack Mackenzie', 'Alto', 5),
        (5, 'Dr. Franklin Hall', 'Alto', 6),
        (6, 'Abigail Brand', 'Alto', 1),
        (7, 'Tyler Hayward', 'Alto', 2),
        (8, 'Woo', 'Alto', 1),
        (9, 'Lance Hunter', 'Alto', 4),
        (10, 'Gaven Kershaw', 'Alto', 1);

INSERT INTO heroe (cod_heroe, n_heroe, poder, cod_gp)
VALUES  (1, 'Iron Man', 'Tecnología avanzada, Inteligencia sobrehumana', 1),
        (2, 'Capitán América', 'Fuerza, Agilidad, Resistencia sobrehumanas, Gran habilidad en combate', 1),
        (3, 'Thor', 'Fuerza sobrehumana, Control del clima y los rayos', 1),
        (4, 'Hulk', 'Fuerza y resistencia sobrehumanas, Regeneración celular, crece de tamaño con la ira', 1),
        (5, 'Black Widow', 'Gran habilidad en combate, Estrategia y sigilo', 1),
        (6, 'Hawkeye', 'Gran habilidad con el arco y flecha, excelente puntería', 1),
        (7, 'Doctor Strange', 'Habilidades mágicas, Teleportación, Viaje en el tiempo', 1),
        (8, 'Spider-Man', 'Fuerza, Agilidad sobrehumanas, Sentido arácnido, Adhesión a las superficies', 1),
        (9, 'Pantera Negra', 'Fuerza, velocidad y resistencia sobrehumanas, habilidades en artes marciales, capacidad de usar el Vibranium en su traje para repeler ataques', 1),
        (10, 'Doctor Strange', 'Habilidades mágicas, Teletransportación, Manipulación del tiempo y el espacio, Creación de portales', 1),
        (11, 'Capitana Marvel', 'Fuerza, velocidad y resistencia sobrehumanas, capacidad de volar y proyectar energía', 1),
        (12, 'Sr. Fantástico', 'Habilidad de estirar y deformar su cuerpo de manera increíble', 2),
        (13, 'Mujer Invisible', 'Capacidad de volverse invisible y crear campos de fuerza', 2),
        (14, 'Antorcha Humana', 'Control del fuego, vuelo y velocidad mejoradas', 2),
        (15, 'La Mole', 'Fuerza sobrehumana y resistencia mejorada, transformación en un ser rocoso y musculoso', 2),
        (16, 'Profesor X', 'Habilidad telepática para leer y controlar mentes', 3),
        (17, 'Magneto', 'Control del magnetismo y manipulación de objetos metálicos', 3),
        (18, 'Wolverine', 'Garras retractables de adamantium, capacidad de curación sobrehumana y sentidos mejorados', 3),
        (19, 'Tormenta', 'Control del clima y manipulación de los elementos naturales', 3),
        (20, 'Cyclops', 'Capacidad de disparar rayos láser ópticos desde sus ojos', 3),
        (21, 'Jean Grey', 'Habilidades telepáticas y telequinéticas, manipulación de la materia y la energía a nivel molecular', 3),
        (22, 'Bestia', 'Fuerza y agilidad mejoradas, inteligencia sobrehumana', 3),
        (23, 'Rogue', 'Capacidad de absorber los poderes y recuerdos de otras personas', 3),
        (24, 'Gambito', 'Capacidad de cargar objetos inanimados con energía explosiva', 3),
        (25, 'Jubilee', 'Generación de fuegos artificiales a partir de su energía mutante', 3);

INSERT INTO juntas (cod_junta, contenido, fecha, lider_j)
VALUES  (1, 'Invasion Alien', '2023-05-15', 1),
        (2, 'Ultron', '2023-05-12', 2);

INSERT INTO invasion_terri (cod_atk, region_afec)
VALUES  (1, 'Sur'),
        (2, 'Noreste'),
        (5, 'Oeste');

INSERT INTO economico (cod_atk, bien_dispu)
VALUES  (1, '0-8-4'),
        (2, 'El Bus'),
        (3, 'La ciudad de Attilan'),
        (4, 'Los Cristales de Gravitonium'),
        (5, 'El suero Centipede');

INSERT INTO mutante (cod_atk, grup_involu, mutan_afec)
VALUES  (4, 'grupo 1', 10),
        (5, 'grupo 2', 20);

INSERT INTO si_sh (rfc, n_ceo, cod_gp_sh)
VALUES  ('ABS000101XXX', 'Obadiah Stane', 1);

INSERT INTO agen_juntas (cod_agen, cod_junta)
VALUES  (1, 1),
        (5, 1),
        (3, 1),
        (7, 2),
        (6, 1),
        (10, 2),
        (1, 2);

INSERT INTO agen_atk (f_inco, f_reti, cod_agen, cod_atk)
VALUES  ('2023-06-01', '2023-06-10', 7, 3),
        ('2023-07-05', '2023-07-14', 9, 1),
        ('2023-08-09', '2023-08-18', 3, 5),
        ('2023-09-12', '2023-09-21', 2, 4),
        ('2023-10-17', '2023-10-26', 8, 2),
        ('2023-11-14', '2023-11-23', 6, 1),
        ('2023-12-05', '2023-12-14', 1, 5),
        ('2024-01-09', '2024-01-18', 5, 3),
        ('2024-02-13', '2024-02-22', 4, 4),
        ('2024-03-19', '2024-03-28', 10, 2);

INSERT INTO lider_eq (cod_lider, cod_eq, cant_eq)
VALUES  (1, 1, 250),
        (1, 2, 50),
        (1, 3, 30),
        (1, 4, 10),
        (2, 2, 5),
        (2, 3, 5);

INSERT INTO sh_atk (f_reti, f_inco, cod_atk, cod_gp_sp)
VALUES  ('2023-06-03', '2023-06-15', 2, 3),
        ('2023-06-10', '2023-06-15', 3, 3),
        ('2023-06-03', '2023-06-14', 4, 3),
        ('2023-06-08', '2023-06-04', 5, 2),
        ('2023-06-03', '2023-06-08', 4, 1),
        ('2023-06-07', '2023-06-13', 2, 2),
        ('2023-06-07', '2023-06-11', 5, 3);

INSERT INTO si_arma (nro_serie, cant_arm, cap_arm, si_rfc)
VALUES  (8570243, 17, 3, 'ABS000101XXX'),
        (3095768, 38, 2, 'ABS000101XXX'),
        (6219854, 24, 1, 'ABS000101XXX'),
        (4782936, 13, 3, 'ABS000101XXX'),
        (1028374, 42, 1, 'ABS000101XXX'),
        (7654289, 29, 2, 'ABS000101XXX'),
        (2947051, 8, 1, 'ABS000101XXX'),
        (8361924, 46, 2, 'ABS000101XXX'),
        (5432167, 11, 3, 'ABS000101XXX'),
        (9203845, 33, 1, 'ABS000101XXX');

INSERT INTO subdivisiones (cod_sub, codshapoya, n_sub, dir_sub)
VALUES  (1, 1, 'División PSI', 1),
        (3, 2, 'S.W.O.R.D.', 5),
        (4, 1, 'Escuadrón Godzilla', 4),
        (2, 3, 'Tormenta de Rayos', 7);
