DELETE FROM areal;

INSERT INTO areal VALUES (
	'Hotel',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 3), -- exterior rectangle (left-up, right-bottom)
		SDO_ORDINATE_ARRAY(20,20, 140,200)
	)
);

INSERT INTO areal VALUES (
	'Služby bazénu',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (clockwise)
		SDO_ORDINATE_ARRAY(20,220, 140,220, 140,380, 20,380, 20,360, 100,360, 100,240, 20,240, 20,220)
	)
);

INSERT INTO areal VALUES (
	'Bazén',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 3), -- exterior rectangle (left-up, right-bottom)
		SDO_ORDINATE_ARRAY(20,260, 80,340)
	)
);

INSERT INTO areal VALUES (
	'Bar+Disko',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 3), -- exterior rectangle (left-up, right-bottom)
		SDO_ORDINATE_ARRAY(160,20, 280,80)
	)
);

INSERT INTO areal VALUES (
	'Tenisové kurty',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 3), -- exterior rectangle (left-up, right-bottom)
		SDO_ORDINATE_ARRAY(160,100, 280,200)
	)
);


INSERT INTO areal VALUES (
	'Wellness',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 3), -- exterior rectangle (left-up, right-bottom)
		SDO_ORDINATE_ARRAY(300,20, 380,180)
	)
);

INSERT INTO areal VALUES (
	'Hlídání dětí',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 3), -- exterior rectangle (left-up, right-bottom)
		SDO_ORDINATE_ARRAY(300,200, 380,240)
	)
);

INSERT INTO areal VALUES (
	'Golfové hřiště',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (clockwise)
		SDO_ORDINATE_ARRAY(280,260, 380,260, 380,380, 200,380, 200,300, 280,300, 280,260)
	)
);



COMMIT;

-- kontrola validity (na zacatku "valid" muze byt cislo chyby, vizte http://www.ora-code.com/)
SELECT nazev, SDO_GEOM.VALIDATE_GEOMETRY_WITH_CONTEXT(geometrie, 1) valid -- 1=presnost
FROM areal;

DELETE FROM mapa;

INSERT INTO mapa VALUES (
	'Karlovarsky',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (clockwise)
		SDO_ORDINATE_ARRAY(
        12,125, 25,112, 37,112, 50,138, 87,112, 112,112, 137,100, 150,112, 175,137, 187,137, 187,200,
        175,225, 162,212, 150,212, 125,237, 112,225, 100,225, 87,237, 50,200, 25,162, 25,150, 12,125 
        )
	)
);

INSERT INTO mapa VALUES (
	'Ustecky',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (clockwise)
		SDO_ORDINATE_ARRAY(
        150,112, 162,100, 187,100, 200,75, 237,75, 237,62, 287,62, 300,50, 325,50, 350,37, 362,37, 350,25, 
        350,0, 362,0, 400,12, 400,37, 412,37, 412,50, 362,87, 362,112, 375,120, 362,150, 350,162, 300,162,
        225,187, 200,200, 187,200, 187,137, 175,137, 150,112
        )
	)
);

INSERT INTO mapa VALUES (
	'Liberecky',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (clockwise)
		SDO_ORDINATE_ARRAY(
        412,50, 450,50, 450,25, 487,25, 500,50, 500,62, 512,75, 537,87, 537,150, 475,150, 437,125, 425,125,
        412,137, 387,137, 375,120, 362,112, 362,87, 412,50
        )
	)
);

INSERT INTO mapa VALUES (
	'Kralovehradecky',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (clockwise)
		SDO_ORDINATE_ARRAY(
        537,87, 562,100, 575,100, 575,112, 587,112, 600,125, 637,125, 650,150, 625,175, 625,187, 637,187, 
        675,250, 650,250, 625,275, 562,237, 500,237, 487,225, 487,200, 462,187, 450,175, 475,150, 537,150,
        537,87
        )
	)
);

INSERT INTO mapa VALUES (
	'Pardubicky',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (clockwise)
		SDO_ORDINATE_ARRAY(
        675,250, 687,250, 712,225, 675,325, 687,350, 687,375, 625,375, 562,337, 550,337, 500,300, 500,275,
        475,250, 500,237, 562,237, 625,275, 650,250, 675,250
        )
	)
);

INSERT INTO mapa VALUES (
	'Olomoucky',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (clockwise)
		SDO_ORDINATE_ARRAY(
        712,225, 712,200, 700,187, 712,175, 787,225, 787,237, 762,262, 750,287, 750,325, 800,350, 837,387,
        837,412, 775,437, 762,437, 725,450, 700,412, 687,425, 675,412, 675,387, 687,375, 687,350, 675,325, 
        712,225
        )
	)
);

INSERT INTO mapa VALUES (
	'Ostravsky',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (clockwise)
		SDO_ORDINATE_ARRAY(
        787,225, 812,225, 825,212, 837,225, 837,250, 825,262, 837,275, 837,287, 850,287, 862,275, 875,275,
        937,325, 950,325, 950,362, 962,375, 975,375, 987,412, 975,425, 937,425, 912,450, 887,425, 862,412,
        837,412, 837,387, 800,350, 750,325, 750,287, 762,262, 787,237, 787,225
        )
	)
);

INSERT INTO mapa VALUES (
	'Zlinsky',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (clockwise)
		SDO_ORDINATE_ARRAY(
        912,450, 900,462, 887,462, 875,475, 875,487, 850,525, 837,525, 825,537, 825,550, 800,550, 750,525,
        725,500, 712,500, 712,487, 725,450, 762,437, 775,437, 837,412, 862,412, 887,425, 912,450   
        )
	)
);

INSERT INTO mapa VALUES (
	'Brnensky',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (clockwise)
		SDO_ORDINATE_ARRAY(
        800,550, 775,562, 737,562, 725,550, 675,600, 662,587, 662,575, 637,575, 612,550, 600,562, 550,562,
        475,512, 550,487, 575,487, 600,462, 600,437, 612,425, 612,400, 625,375, 687,375, 675,387, 675,412,        
        687,425, 700,412, 725,450, 712,487, 712,500, 725,500, 750,525, 800,550
        )
	)
);

INSERT INTO mapa VALUES (
	'Jihlavsky',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (clockwise)
		SDO_ORDINATE_ARRAY(
        475,512, 487,500, 475,487, 487,462, 450,450, 387,400, 400,362, 412,350, 450,337, 450,325, 487,300,
        500,300, 550,337, 562,337, 625,375, 612,400, 612,425, 600,437, 600,462, 575,487, 550,487, 475,512
        )
	)
);

INSERT INTO mapa VALUES (
	'Budejovicky',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (clockwise)
		SDO_ORDINATE_ARRAY(
        475,512, 450,487, 437,502, 425,502, 412,489, 400,502, 400,526, 387,539, 362,539, 350,562, 337,562,
        312,552, 287,575, 237,539, 225,514, 175,464, 212,412, 225,387, 237,350, 237,337, 262,350, 275,337,
        300,350, 350,350, 362,362, 387,337, 400,362, 387,400, 450,450, 487,462, 475,487, 487,500, 475,512
        )
	)
);

INSERT INTO mapa VALUES (
	'Plzensky',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (clockwise)
		SDO_ORDINATE_ARRAY(
        175,464, 100,362, 75,350, 37,250, 75,225, 87,237, 100,225, 112,225, 125,237, 150,212, 162,212, 175,225,
        187,200, 200,200, 200,212, 250,250, 250,287, 225,287, 225,325, 237,337, 237,350, 225,387, 212,412,
        175,464
        )
	)
);

INSERT INTO mapa VALUES (
	'Stredocesky',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 1, 75, 2003, 1), -- polygon with hole, second threesome (start index, type, i)
		SDO_ORDINATE_ARRAY(
        200,200, 225,187, 300,162, 350,162, 362,150, 375,120, 387,137, 412,137, 425,125, 437,125, 475,150,
        450,175, 462,187, 487,200, 487,225, 500,237, 475,250, 500,275, 500,300, 487,300, 450,325, 450,337,
        412,350, 400,362, 387,337, 362,362, 350,350, 300,350, 275,337, 262,350, 237,337, 225,325, 225,287,
        250,287, 250,250, 200,212, 200,200,
        
        --362,200, 387,225, 387,250, 350,250, 337,262, 325,237, 325,212, 337,212, 350,200, 362,200
        --Counterclockwise
        362,200, 350,200, 337,212, 325,212, 325,237, 337,262, 350,250, 387,250, 387,225, 362,200
        )
	)
);

INSERT INTO mapa VALUES (
	'Hl. m. Praha',
	SDO_GEOMETRY(2003, NULL, NULL, -- 2D polygon
		SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- polygon with hole, second threesome (start index, type, i)
		SDO_ORDINATE_ARRAY(
        362,200, 387,225, 387,250, 350,250, 337,262, 325,237, 325,212, 337,212, 350,200, 362,200
        )
	)
);
COMMIT;

-- kontrola validity (na zacatku "valid" muze byt cislo chyby, vizte http://www.ora-code.com/)
SELECT nazev, SDO_GEOM.VALIDATE_GEOMETRY_WITH_CONTEXT(geometrie, 1) valid -- 1=presnost
FROM mapa;



INSERT INTO pokoje (id, nazev) VALUES (1, 'Pokoj 1');
INSERT INTO pokoje (id, nazev) VALUES (2, 'Pokoj 2');
INSERT INTO pokoje (id, nazev) VALUES (3, 'Pokoj 3');
INSERT INTO pokoje (id, nazev) VALUES (4, 'Pokoj 4');
INSERT INTO pokoje (id, nazev) VALUES (5, 'Pokoj 5');
INSERT INTO pokoje (id, nazev) VALUES (6, 'Pokoj 6');
INSERT INTO pokoje (id, nazev) VALUES (7, 'Pokoj 7');
INSERT INTO pokoje (id, nazev) VALUES (8, 'Pokoj 8');
INSERT INTO pokoje (id, nazev) VALUES (9, 'Pokoj 9');
INSERT INTO pokoje (id, nazev) VALUES (10, 'Pokoj 10');


INSERT INTO zakaznik (jmeno, prijmeni, adresa, mesto, psc, kraj, telefon, email) VALUES ('Mira', 'x', 'x', 'x', 'x', 'x', 'x', 'x');
INSERT INTO zakaznik (jmeno, prijmeni, adresa, mesto, psc, kraj, telefon, email) VALUES ('Tom', 'x', 'x', 'x', 'x', 'x', 'x', 'x');
INSERT INTO zakaznik (jmeno, prijmeni, adresa, mesto, psc, kraj, telefon, email) VALUES ('Pavel', 'x', 'x', 'x', 'x', 'x', 'x', 'x');
INSERT INTO zakaznik (jmeno, prijmeni, adresa, mesto, psc, kraj, telefon, email) VALUES ('pres-cele-svatky', 'x', 'x', 'x', 'x', 'x', 'x', 'x');
INSERT INTO zakaznik (jmeno, prijmeni, adresa, mesto, psc, kraj, telefon, email) VALUES ('pred-uprostred', 'x', 'x', 'x', 'x', 'x', 'x', 'x');
INSERT INTO zakaznik (jmeno, prijmeni, adresa, mesto, psc, kraj, telefon, email) VALUES ('uprostred-svatku', 'x', 'x', 'x', 'x', 'x', 'x', 'x');
INSERT INTO zakaznik (jmeno, prijmeni, adresa, mesto, psc, kraj, telefon, email) VALUES ('mimo', 'x', 'x', 'x', 'x', 'x', 'x', 'x');
INSERT INTO zakaznik (jmeno, prijmeni, adresa, mesto, psc, kraj, telefon, email) VALUES ('uprostred-po', 'x', 'x', 'x', 'x', 'x', 'x', 'x');


COMMIT;

INSERT INTO sluzby (nazev, objekt, dostupnost_od, dostupnost_do)
VALUES ('Tenisové kurty', 'Tenisové kurty', 8, 18);

INSERT INTO sluzby (nazev, objekt, dostupnost_od, dostupnost_do)
VALUES ('Wellness', 'Wellness', 12, 18);

INSERT INTO sluzby (nazev, objekt, dostupnost_od, dostupnost_do)
VALUES ('Hlídání dětí', 'Hlídání dětí', 6, 14);

INSERT INTO sluzby (nazev, objekt, dostupnost_od, dostupnost_do)
VALUES ('Golfové hřiště', 'Golfové hřiště', 11, 17);


COMMIT;

INSERT INTO sluzby_rezervace (sluzba, zakaznik, den, hodina)
VALUES ('Tenisové kurty', 1002, TO_DATE('2013-12-13', 'yyyy-mm-dd'), '11');

INSERT INTO sluzby_rezervace (sluzba, zakaznik, den, hodina)
VALUES ('Tenisové kurty', 1001, TO_DATE('2013-12-14', 'yyyy-mm-dd'), 12);

INSERT INTO sluzby_rezervace (sluzba, zakaznik, den, hodina)
VALUES ('Tenisové kurty', 1003, TO_DATE('2013-12-13', 'yyyy-mm-dd'), 14);


COMMIT;

INSERT INTO rezervace (id,zakaznik,pokoj,od,do)
VALUES (1,1004,1,TO_DATE('2013-12-20', 'yyyy-mm-dd'),TO_DATE('2013-12-30', 'yyyy-mm-dd'));

INSERT INTO rezervace (id,zakaznik,pokoj,od,do)
VALUES (2,1005,2,TO_DATE('2013-12-20', 'yyyy-mm-dd'),TO_DATE('2013-12-25', 'yyyy-mm-dd'));

INSERT INTO rezervace (id,zakaznik,pokoj,od,do)
VALUES (3,1006,3,TO_DATE('2013-12-24', 'yyyy-mm-dd'),TO_DATE('2013-12-25', 'yyyy-mm-dd'));

INSERT INTO rezervace (id,zakaznik,pokoj,od,do)
VALUES (4,1007,4,TO_DATE('2013-12-20', 'yyyy-mm-dd'),TO_DATE('2013-12-22', 'yyyy-mm-dd'));

INSERT INTO rezervace (id,zakaznik,pokoj,od,do)
VALUES (5,1008,5,TO_DATE('2013-12-24', 'yyyy-mm-dd'),TO_DATE('2013-12-28', 'yyyy-mm-dd'));

COMMIT;