CREATE TABLE agentes (
    cod_agen integer NOT NULL,
    n_agen VARCHAR(50) NOT NULL,
    espe VARCHAR(50) NOT NULL,
    tp_ayuda VARCHAR(50) NOT NULL,
    agen_dir integer DEFAULT 0,
    CONSTRAINT agentes_pkey PRIMARY KEY (cod_agen),
    CONSTRAINT agen_dir_fkey FOREIGN KEY (agen_dir) REFERENCES agentes ON DELETE CASCADE
);

CREATE TABLE capacidad (
    cod_cap integer NOT NULL,
    tp_cap VARCHAR(50) NOT NULL,
    CONSTRAINT capacidad_pkey PRIMARY KEY (cod_cap)
);

CREATE TABLE equipo (
    cod_eq integer NOT NULL,
    n_eq VARCHAR(50) NOT NULL,
    CONSTRAINT equipo_pkey PRIMARY KEY (cod_eq)
);

CREATE TABLE grupo_sh (
    cod_gp_sp integer NOT NULL,
    n_gp VARCHAR(50) NOT NULL,
    CONSTRAINT grupo_sh_pkey PRIMARY KEY (cod_gp_sp)
);

CREATE TABLE paises (
    cod_pais char(4) NOT NULL,
    n_pais VARCHAR(50) NOT NULL,
    CONSTRAINT paises_pkey PRIMARY KEY (cod_pais)
);

CREATE TABLE tp_alien (
    cod_alien integer NOT NULL,
    raza_alien VARCHAR(50) NOT NULL,
    CONSTRAINT extraterrestre_pk PRIMARY KEY (cod_alien)
);

CREATE TABLE ataque (
    cod_atk integer NOT NULL,
    n_atk VARCHAR(50) NOT NULL,
    nro_bajas integer NOT NULL,
    nro_heridos integer NOT NULL,
    pais_atk char(4),
    CONSTRAINT ataque_pkey PRIMARY KEY (cod_atk),
    CONSTRAINT pais_atk_fkey FOREIGN KEY (pais_atk) REFERENCES paises ON DELETE CASCADE
);

CREATE TABLE lider (
    cod_lider integer NOT NULL,
    cod_gp_sh integer NOT NULL,
    n_lider VARCHAR(50) NOT NULL,
    CONSTRAINT lider_pkey PRIMARY KEY (cod_lider),
    CONSTRAINT lider_cod_gp_sh_fkey FOREIGN KEY (cod_gp_sh) REFERENCES grupo_sh ON DELETE CASCADE
);

CREATE TABLE director (
    cod_dir integer NOT NULL,
    n_dir VARCHAR(50) NOT NULL,
    rango_dir VARCHAR(50) NOT NULL,
    lider integer NOT NULL,
    CONSTRAINT director_pkey PRIMARY KEY (cod_dir),
    CONSTRAINT director_lider_fkey FOREIGN KEY (lider) REFERENCES lider ON DELETE CASCADE
);

CREATE TABLE heroe (
    cod_heroe integer NOT NULL,
    n_heroe VARCHAR(20) NOT NULL,
    poder text NOT NULL,
    cod_gp integer,
    CONSTRAINT heroe_pkey PRIMARY KEY (cod_heroe),
    CONSTRAINT heroe_cod_gp_fkey FOREIGN KEY (cod_gp) REFERENCES grupo_sh ON DELETE CASCADE
);

CREATE TABLE juntas (
    cod_junta integer NOT NULL,
    contenido VARCHAR(100) NOT NULL,
    fecha date NOT NULL,
    lider_j integer NOT NULL,
    CONSTRAINT juntas_pkey PRIMARY KEY (cod_junta),
    CONSTRAINT lider_j_fkey FOREIGN KEY (lider_j) REFERENCES lider ON DELETE CASCADE
);

CREATE TABLE invasion_terri (
    cod_atk integer NOT NULL,
    region_afec VARCHAR(50) NOT NULL,
    CONSTRAINT invasion_terri_pkey PRIMARY KEY (cod_atk),
    CONSTRAINT invasion_terri_cod_atk_fkey FOREIGN KEY (cod_atk) REFERENCES ataque ON DELETE CASCADE
);

CREATE TABLE economico (
    cod_atk integer NOT NULL,
    bien_dispu VARCHAR(50) NOT NULL,
    CONSTRAINT economico_pkey PRIMARY KEY (cod_atk),
    CONSTRAINT economico_cod_atk_fkey FOREIGN KEY (cod_atk) REFERENCES ataque ON DELETE CASCADE
);

CREATE TABLE mutante (
    cod_atk integer NOT NULL,
    grup_involu VARCHAR(50) NOT NULL,
    mutan_afec integer NOT NULL,
    CONSTRAINT mutante_pkey PRIMARY KEY (cod_atk),
    CONSTRAINT mutante_cod_atk_fkey FOREIGN KEY (cod_atk) REFERENCES ataque ON DELETE CASCADE
);

CREATE TABLE si_sh (
    rfc VARCHAR(50) NOT NULL,
    n_ceo VARCHAR NOT NULL,
    cod_gp_sh integer NOT NULL,
    CONSTRAINT si_sh_pkey PRIMARY KEY (rfc),
    CONSTRAINT si_sh_cod_gp_sh_fkey FOREIGN KEY (cod_gp_sh) REFERENCES grupo_sh ON DELETE CASCADE
);

CREATE TABLE agen_juntas (
    cod_agen integer NOT NULL,
    cod_junta integer NOT NULL,
    CONSTRAINT agen_juntas_pkey PRIMARY KEY (cod_agen, cod_junta),
    CONSTRAINT agen_juntas_cod_agen_fkey FOREIGN KEY (cod_agen) REFERENCES agentes ON DELETE CASCADE,
    CONSTRAINT agen_juntas_cod_junta_fkey FOREIGN KEY (cod_junta) REFERENCES juntas ON DELETE CASCADE
);

CREATE TABLE agen_atk (
    f_inco date NOT NULL,
    f_reti date NOT NULL,
    cod_agen integer NOT NULL,
    cod_atk integer NOT NULL,
    CONSTRAINT agen_atk_pkey PRIMARY KEY (cod_agen, cod_atk),
    CONSTRAINT agen_atk_cod_agen_fkey FOREIGN KEY (cod_agen) REFERENCES agentes ON DELETE CASCADE,
    CONSTRAINT agen_atk_cod_atk_fkey FOREIGN KEY (cod_atk) REFERENCES ataque ON DELETE CASCADE
);

CREATE TABLE lider_eq (
    cod_lider integer NOT NULL,
    cod_eq integer NOT NULL,
    cant_eq integer NOT NULL,
    CONSTRAINT lider_eq_pkey PRIMARY KEY (cod_lider, cod_eq),
    CONSTRAINT lider_eq_cod_lider_fkey FOREIGN KEY (cod_lider) REFERENCES lider ON DELETE CASCADE,
    CONSTRAINT lider_eq_cod_eq_fkey FOREIGN KEY (cod_eq) REFERENCES equipo ON DELETE CASCADE
);

CREATE TABLE sh_atk (
    f_reti date NOT NULL,
    f_inco date NOT NULL,
    cod_atk integer NOT NULL,
    cod_gp_sp integer NOT NULL,
    CONSTRAINT sh_atk_pkey PRIMARY KEY (cod_atk, cod_gp_sp),
    CONSTRAINT sh_atk_cod_atk_fkey FOREIGN KEY (cod_atk) REFERENCES ataque ON DELETE CASCADE,
    CONSTRAINT sh_atk_cod_gp_sp_fkey FOREIGN KEY (cod_gp_sp) REFERENCES grupo_sh ON DELETE CASCADE
);

CREATE TABLE si_arma (
    nro_serie integer NOT NULL,
    cant_arm integer NOT NULL,
    cap_arm integer NOT NULL,
    si_rfc VARCHAR(50) NOT NULL,
    CONSTRAINT si_arma_pkey PRIMARY KEY (nro_serie),
    CONSTRAINT si_arma_cap_arm_fkey FOREIGN KEY (cap_arm) REFERENCES capacidad ON DELETE CASCADE,
    CONSTRAINT si_arma_rfc_fkey FOREIGN KEY (si_rfc) REFERENCES si_sh ON DELETE CASCADE
);

CREATE TABLE subdivisiones (
    cod_sub integer NOT NULL,
    codshapoya integer NOT NULL,
    n_sub VARCHAR(20) NOT NULL,
    dir_sub integer,
    CONSTRAINT subdivisiones_pkey PRIMARY KEY (cod_sub),
    CONSTRAINT subdivisiones_codshapoya_fkey FOREIGN KEY (codshapoya) REFERENCES grupo_sh ON DELETE CASCADE,
    CONSTRAINT dir_sub_fkey FOREIGN KEY (dir_sub) REFERENCES director ON DELETE CASCADE
);