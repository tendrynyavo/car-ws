--
-- PostgreSQL database dump
--

-- Dumped from database version 15.4 (Debian 15.4-3)
-- Dumped by pg_dump version 15.4 (Debian 15.4-3)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: annonce; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.annonce (
    id_annonce integer NOT NULL,
    date_heure_publication timestamp without time zone,
    user_id integer NOT NULL,
    prix double precision
);


ALTER TABLE public.annonce OWNER TO postgres;

--
-- Name: annonce_id_annonce_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.annonce_id_annonce_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.annonce_id_annonce_seq OWNER TO postgres;

--
-- Name: annonce_id_annonce_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.annonce_id_annonce_seq OWNED BY public.annonce.id_annonce;


--
-- Name: annonce_photo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.annonce_photo (
    id_photo integer NOT NULL,
    id_annonce integer NOT NULL,
    photo character varying(250)
);


ALTER TABLE public.annonce_photo OWNER TO postgres;

--
-- Name: annonce_photo_id_photo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.annonce_photo_id_photo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.annonce_photo_id_photo_seq OWNER TO postgres;

--
-- Name: annonce_photo_id_photo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.annonce_photo_id_photo_seq OWNED BY public.annonce_photo.id_photo;


--
-- Name: annonce_vendus; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.annonce_vendus (
    id_vendus integer NOT NULL,
    id_annonce integer NOT NULL,
    date_vendus date
);


ALTER TABLE public.annonce_vendus OWNER TO postgres;

--
-- Name: annonce_vendus_id_vendus_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.annonce_vendus_id_vendus_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.annonce_vendus_id_vendus_seq OWNER TO postgres;

--
-- Name: annonce_vendus_id_vendus_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.annonce_vendus_id_vendus_seq OWNED BY public.annonce_vendus.id_vendus;


--
-- Name: categorie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categorie (
    id_categorie integer NOT NULL,
    nom_categorie character varying(50) NOT NULL
);


ALTER TABLE public.categorie OWNER TO postgres;

--
-- Name: categorie_id_categorie_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categorie_id_categorie_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categorie_id_categorie_seq OWNER TO postgres;

--
-- Name: categorie_id_categorie_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categorie_id_categorie_seq OWNED BY public.categorie.id_categorie;


--
-- Name: commission; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commission (
    value double precision DEFAULT 0
);


ALTER TABLE public.commission OWNER TO postgres;

--
-- Name: detail_annonce; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detail_annonce (
    id_detail_annonce integer NOT NULL,
    id_annonce integer NOT NULL,
    modele integer NOT NULL,
    categorie integer NOT NULL,
    marque integer NOT NULL,
    kilometrage integer DEFAULT 0,
    date_achat date,
    description character varying(150)
);


ALTER TABLE public.detail_annonce OWNER TO postgres;

--
-- Name: detail_annonce_id_detail_annonce_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.detail_annonce_id_detail_annonce_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detail_annonce_id_detail_annonce_seq OWNER TO postgres;

--
-- Name: detail_annonce_id_detail_annonce_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.detail_annonce_id_detail_annonce_seq OWNED BY public.detail_annonce.id_detail_annonce;


--
-- Name: favoris; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.favoris (
    id_favoris integer NOT NULL,
    id_annonce integer NOT NULL,
    date_ajout date,
    users integer NOT NULL
);


ALTER TABLE public.favoris OWNER TO postgres;

--
-- Name: favoris_id_favoris_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.favoris_id_favoris_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.favoris_id_favoris_seq OWNER TO postgres;

--
-- Name: favoris_id_favoris_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.favoris_id_favoris_seq OWNED BY public.favoris.id_favoris;


--
-- Name: marque; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.marque (
    id_marque integer NOT NULL,
    nom_marque character varying(50) NOT NULL
);


ALTER TABLE public.marque OWNER TO postgres;

--
-- Name: marque_id_marque_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.marque_id_marque_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.marque_id_marque_seq OWNER TO postgres;

--
-- Name: marque_id_marque_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.marque_id_marque_seq OWNED BY public.marque.id_marque;


--
-- Name: message; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.message (
    id_message integer NOT NULL,
    envoyeur integer NOT NULL,
    receveur integer NOT NULL,
    date_heure_envoie timestamp without time zone,
    message text
);


ALTER TABLE public.message OWNER TO postgres;

--
-- Name: message_id_message_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.message_id_message_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.message_id_message_seq OWNER TO postgres;

--
-- Name: message_id_message_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.message_id_message_seq OWNED BY public.message.id_message;


--
-- Name: modele; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.modele (
    id_modele integer NOT NULL,
    nom_modele character varying(50) NOT NULL
);


ALTER TABLE public.modele OWNER TO postgres;

--
-- Name: modele_id_modele_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.modele_id_modele_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.modele_id_modele_seq OWNER TO postgres;

--
-- Name: modele_id_modele_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.modele_id_modele_seq OWNED BY public.modele.id_modele;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id_user integer NOT NULL,
    nom character varying(100) NOT NULL,
    prenom character varying(100),
    mail character varying(100) NOT NULL,
    contact character varying(50),
    password character varying(100)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_user_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_user_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_user_seq OWNER TO postgres;

--
-- Name: users_id_user_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_user_seq OWNED BY public.users.id_user;


--
-- Name: annonce id_annonce; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.annonce ALTER COLUMN id_annonce SET DEFAULT nextval('public.annonce_id_annonce_seq'::regclass);


--
-- Name: annonce_photo id_photo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.annonce_photo ALTER COLUMN id_photo SET DEFAULT nextval('public.annonce_photo_id_photo_seq'::regclass);


--
-- Name: annonce_vendus id_vendus; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.annonce_vendus ALTER COLUMN id_vendus SET DEFAULT nextval('public.annonce_vendus_id_vendus_seq'::regclass);


--
-- Name: categorie id_categorie; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categorie ALTER COLUMN id_categorie SET DEFAULT nextval('public.categorie_id_categorie_seq'::regclass);


--
-- Name: detail_annonce id_detail_annonce; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detail_annonce ALTER COLUMN id_detail_annonce SET DEFAULT nextval('public.detail_annonce_id_detail_annonce_seq'::regclass);


--
-- Name: favoris id_favoris; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favoris ALTER COLUMN id_favoris SET DEFAULT nextval('public.favoris_id_favoris_seq'::regclass);


--
-- Name: marque id_marque; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marque ALTER COLUMN id_marque SET DEFAULT nextval('public.marque_id_marque_seq'::regclass);


--
-- Name: message id_message; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message ALTER COLUMN id_message SET DEFAULT nextval('public.message_id_message_seq'::regclass);


--
-- Name: modele id_modele; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modele ALTER COLUMN id_modele SET DEFAULT nextval('public.modele_id_modele_seq'::regclass);


--
-- Name: users id_user; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id_user SET DEFAULT nextval('public.users_id_user_seq'::regclass);


--
-- Data for Name: annonce; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.annonce (id_annonce, date_heure_publication, user_id, prix) FROM stdin;
\.


--
-- Data for Name: annonce_photo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.annonce_photo (id_photo, id_annonce, photo) FROM stdin;
\.


--
-- Data for Name: annonce_vendus; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.annonce_vendus (id_vendus, id_annonce, date_vendus) FROM stdin;
\.


--
-- Data for Name: categorie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categorie (id_categorie, nom_categorie) FROM stdin;
1	Camion
2	Taxi
3	Plaisir
\.


--
-- Data for Name: commission; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.commission (value) FROM stdin;
\.


--
-- Data for Name: detail_annonce; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.detail_annonce (id_detail_annonce, id_annonce, modele, categorie, marque, kilometrage, date_achat, description) FROM stdin;
\.


--
-- Data for Name: favoris; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.favoris (id_favoris, id_annonce, date_ajout, users) FROM stdin;
\.


--
-- Data for Name: marque; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.marque (id_marque, nom_marque) FROM stdin;
\.


--
-- Data for Name: message; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.message (id_message, envoyeur, receveur, date_heure_envoie, message) FROM stdin;
\.


--
-- Data for Name: modele; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.modele (id_modele, nom_modele) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id_user, nom, prenom, mail, contact, password) FROM stdin;
\.


--
-- Name: annonce_id_annonce_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.annonce_id_annonce_seq', 1, false);


--
-- Name: annonce_photo_id_photo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.annonce_photo_id_photo_seq', 1, false);


--
-- Name: annonce_vendus_id_vendus_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.annonce_vendus_id_vendus_seq', 1, false);


--
-- Name: categorie_id_categorie_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categorie_id_categorie_seq', 3, true);


--
-- Name: detail_annonce_id_detail_annonce_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.detail_annonce_id_detail_annonce_seq', 1, false);


--
-- Name: favoris_id_favoris_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.favoris_id_favoris_seq', 1, false);


--
-- Name: marque_id_marque_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.marque_id_marque_seq', 1, false);


--
-- Name: message_id_message_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.message_id_message_seq', 1, false);


--
-- Name: modele_id_modele_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.modele_id_modele_seq', 1, false);


--
-- Name: users_id_user_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_user_seq', 1, false);


--
-- Name: annonce_photo annonce_photo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.annonce_photo
    ADD CONSTRAINT annonce_photo_pkey PRIMARY KEY (id_photo);


--
-- Name: annonce annonce_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.annonce
    ADD CONSTRAINT annonce_pkey PRIMARY KEY (id_annonce);


--
-- Name: annonce_vendus annonce_vendus_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.annonce_vendus
    ADD CONSTRAINT annonce_vendus_pkey PRIMARY KEY (id_vendus);


--
-- Name: categorie categorie_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categorie
    ADD CONSTRAINT categorie_pkey PRIMARY KEY (id_categorie);


--
-- Name: detail_annonce detail_annonce_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detail_annonce
    ADD CONSTRAINT detail_annonce_pkey PRIMARY KEY (id_detail_annonce);


--
-- Name: favoris favoris_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favoris
    ADD CONSTRAINT favoris_pkey PRIMARY KEY (id_favoris);


--
-- Name: marque marque_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marque
    ADD CONSTRAINT marque_pkey PRIMARY KEY (id_marque);


--
-- Name: message message_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_pkey PRIMARY KEY (id_message);


--
-- Name: modele modele_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modele
    ADD CONSTRAINT modele_pkey PRIMARY KEY (id_modele);


--
-- Name: favoris unq_favoris_users; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favoris
    ADD CONSTRAINT unq_favoris_users UNIQUE (users);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id_user);


--
-- Name: annonce_photo annonce_photo_id_annonce_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.annonce_photo
    ADD CONSTRAINT annonce_photo_id_annonce_fkey FOREIGN KEY (id_annonce) REFERENCES public.annonce(id_annonce);


--
-- Name: annonce annonce_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.annonce
    ADD CONSTRAINT annonce_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id_user);


--
-- Name: annonce_vendus annonce_vendus_id_annonce_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.annonce_vendus
    ADD CONSTRAINT annonce_vendus_id_annonce_fkey FOREIGN KEY (id_annonce) REFERENCES public.annonce(id_annonce);


--
-- Name: detail_annonce detail_annonce_categorie_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detail_annonce
    ADD CONSTRAINT detail_annonce_categorie_fkey FOREIGN KEY (categorie) REFERENCES public.categorie(id_categorie);


--
-- Name: detail_annonce detail_annonce_id_annonce_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detail_annonce
    ADD CONSTRAINT detail_annonce_id_annonce_fkey FOREIGN KEY (id_annonce) REFERENCES public.annonce(id_annonce);


--
-- Name: detail_annonce detail_annonce_marque_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detail_annonce
    ADD CONSTRAINT detail_annonce_marque_fkey FOREIGN KEY (marque) REFERENCES public.marque(id_marque);


--
-- Name: detail_annonce detail_annonce_modele_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detail_annonce
    ADD CONSTRAINT detail_annonce_modele_fkey FOREIGN KEY (modele) REFERENCES public.modele(id_modele);


--
-- Name: favoris favoris_id_annonce_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favoris
    ADD CONSTRAINT favoris_id_annonce_fkey FOREIGN KEY (id_annonce) REFERENCES public.annonce(id_annonce);


--
-- Name: favoris fk_favoris_users; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favoris
    ADD CONSTRAINT fk_favoris_users FOREIGN KEY (users) REFERENCES public.users(id_user);


--
-- Name: message message_envoyeur_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_envoyeur_fkey FOREIGN KEY (envoyeur) REFERENCES public.users(id_user);


--
-- Name: message message_receveur_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_receveur_fkey FOREIGN KEY (receveur) REFERENCES public.users(id_user);


--
-- PostgreSQL database dump complete
--

