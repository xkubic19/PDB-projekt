DROP TABLE pokoje;

/** pokoje */
CREATE TABLE pokoje (
	id NUMBER NOT null,
	nazev VARCHAR(32),
	CONSTRAINT pk_pokoje PRIMARY KEY (id)
);


/** doplnit data do pokoju rucne */

/** prozatim jen hloupa data bez geometrie */

INSERT INTO pokoje (id, nazev) VALUES (1, "Pokoj 1");
INSERT INTO pokoje (id, nazev) VALUES (2, "Pokoj 2");
INSERT INTO pokoje (id, nazev) VALUES (3, "Pokoj 3");


DROP TABLE rezervace;

/** rezervace pokoju */
CREATE TABLE rezervace (
  	id NUMBER NOT null,
	zakaznik NUMBER NOT null,
	pokoj NUMBER NOT null,
	od DATE NOT null,
	do DATE NOT null,
	CONSTRAINT pk_rezervace PRIMARY KEY (id),
	CONSTRAINT fk_rezervace_zakaznik FOREIGN KEY (zakaznik) REFERENCES zakaznik(id),
	CONSTRAINT fk_rezervace_pokoj FOREIGN KEY (pokoj) REFERENCES pokoje(id),
	CONSTRAINT uc_rezervace_pokoj_od_do UNIQUE (pokoj,od,do)
);

DROP SEQUENCE rezervace_seq;

CREATE SEQUENCE rezervace_seq
START WITH 1 INCREMENT BY 1;
/****************************************/

COMMIT;

create or replace trigger rezervace_insert
before insert on rezervace
for each row
begin
    select rezervace_seq.nextval into :new.id from dual;
end;
/

COMMIT;
