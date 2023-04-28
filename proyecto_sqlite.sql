drop table if EXISTS  USUARIOS;
CREATE TABLE USUARIOS (
  id_usuario INTEGER PRIMARY KEY ,
  nombre TEXT CHECK (nombre regexp '^[a-zA-Z ]+$'),
  dni TEXT CHECK(length(dni) = 8),
  direccion TEXT CHECK (direccion regexp '^[a-zA-Z0-9 .,-]+$'),
  telefono TEXT CHECK(length(dni) = 9),
  email TEXT CHECK(email LIKE '%@%.%'),
  rol TEXT  check(rol IN ('administrador','usuario''invitado')),
  contrasenna TEXT CHECK (contrasenna regexp '^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&*]).{8,}$')
);


drop table if EXISTS RESERVAS;
CREATE TABLE RESERVAS(
  codigo_reserva INTEGER PRIMARY KEY,
  duracion TEXT,
  hora TEXT,
  fecha_reserva TEXT,
  email TEXT CHECK(email LIKE '%@%.%'),
  motivo TEXT,
  adjudicada INTEGER,
  id_usuario TEXT CHECK (id_usuario regexp '^[a-zA-Z0-9]+$'),
  FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);