--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2 (Ubuntu 13.2-1.pgdg20.04+1)
-- Dumped by pg_dump version 13.0

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
-- Name: income; Type: TABLE; Schema: public; Owner: dnxefbukwnniwx
--

CREATE TABLE public.income (
    code integer NOT NULL,
    multipler integer NOT NULL,
    description character varying(255) NOT NULL
);


ALTER TABLE public.income OWNER TO dnxefbukwnniwx;

--
-- Name: user_score; Type: TABLE; Schema: public; Owner: dnxefbukwnniwx
--

CREATE TABLE public.user_score (
    identity_number character varying(11) NOT NULL,
    phone character varying(50) NOT NULL,
    name character varying(50) NOT NULL,
    surname character varying(50) NOT NULL,
    city character varying(5) NOT NULL,
    score integer
);


ALTER TABLE public.user_score OWNER TO dnxefbukwnniwx;

--
-- Data for Name: income; Type: TABLE DATA; Schema: public; Owner: dnxefbukwnniwx
--

COPY public.income (code, multipler, description) FROM stdin;
1	800	0-2999TL
2	1000	3000TL-4999TL
3	1200	5000TL-7999TL
4	1500	8000TL-11999TL
5	2000	12000TL ve üzeri
\.


--
-- Data for Name: user_score; Type: TABLE DATA; Schema: public; Owner: dnxefbukwnniwx
--

COPY public.user_score (identity_number, phone, name, surname, city, score) FROM stdin;
40213858494	+905394505757	Özgün Gökşenli	Gökşenli	i03	9603
ads	905390459999	Özgün	Gökşenli	i03	3603
Identity	905394505757	Özgün	Gökşenli	i07	4802
\.


--
-- Name: income income_pkey; Type: CONSTRAINT; Schema: public; Owner: dnxefbukwnniwx
--

ALTER TABLE ONLY public.income
    ADD CONSTRAINT income_pkey PRIMARY KEY (code);


--
-- Name: user_score user_score_pkey; Type: CONSTRAINT; Schema: public; Owner: dnxefbukwnniwx
--

ALTER TABLE ONLY public.user_score
    ADD CONSTRAINT user_score_pkey PRIMARY KEY (identity_number);


--
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: dnxefbukwnniwx
--

REVOKE ALL ON SCHEMA public FROM postgres;
REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO dnxefbukwnniwx;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- Name: LANGUAGE plpgsql; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON LANGUAGE plpgsql TO dnxefbukwnniwx;


--
-- PostgreSQL database dump complete
--

