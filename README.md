# ABPRO-7


Una empresa de asesorías en prevención de riesgos necesita contar con un sistema de información que le permita administrar los principales procesos que se llevan a cabo en ella día a día.
Hasta el momento se han definido algunas entidades que darán vida al sistema. Estas son:

Cliente:
- RUT: corresponde a un número menor a 99.999.999
- Nombres
- Apellidos
- Teléfono
- AFP
- Sistema de salud: 1 (Fonasa) o 2 (Isapre)
- Dirección
- Comuna
- Edad

Usuario:
- Nombre
- Fecha de nacimiento
- RUN

Capacitación
- Identificador: número interno de la capacitación manejado por la empresa
- Día
- Hora
- Lugar
- Duración
- Cantidad de asistentes

Accidente
- Identificador del accidente, número interno manejado por la compañía.
- Día
- Hora
- Lugar
- Origen
- Consecuencias

Visita en terreno
- Identificador de la visita en terreno
- Día
- Hora
- Lugar
- Comentarios

Revisión
- Identificador de la revisión
- Nombre alusivo a la revisión
- Detalle para revisar
- Estado: 1 (sin problemas), 2 (con observaciones), 3 (no aprueba)

Además, respecto de las clases anteriores se conoce lo siguiente:
- Un cliente puede tomar ninguna o muchas capacitaciones
- Un cliente puede registrar ninguno o muchos accidentes
- Un cliente debe tener una o muchas visitas en terreno
- Una visita en terreno debe tener una o más revisiones por cada ocasión
Desarrolle un diagrama de clases en base a las entidades, atributos y asociaciones identificadas anteriormente.
