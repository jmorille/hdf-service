create table referentiel (
  id varchar(255) not null,
  sens varchar(3),
  code varchar(255),
  libelle varchar(255),
  type varchar(255),
  primary key (id)
);

create table flux (
   id varchar(255) not null,
   commentaire TEXT,
   date_annulation timestamp,
   date_debut_delai timestamp,
   date_fin_delai timestamp,
   date_reception timestamp,
   id_gateway integer,
   primary key (id)
);
