create table config
(
    id            bigint       not null auto_increment,
    creation_date timestamp    not null default current_timestamp,
    data_json     json         not null,
    platform      varchar(255) not null,
    version       bigint       not null,
    primary key (id),
    unique (platform, version)
);

create table base
(
    id            bigint       not null auto_increment,
    creation_date timestamp    not null default current_timestamp,
    data_json     json         not null,
    version       bigint       not null,
    primary key (id)
);


insert into base (data_json, version)
values(
          '{
            "config1": "config1",
            "config2": "config2",
            "config3": {
              "config31": [{"config311":"new config3.1.1"}],
              "config32": "config3.2"
            }
          }',
          1
      );

insert into config (data_json, platform, version)
values (
        '{
            "config3": {
                "config31": "config3.1",
                "config32": "config3.2"
            }
        }',
        'plinth',
        2
);

insert into config (data_json, platform, version)
values (
           '{
             "config1": "1config",
             "config2": "2config"
           }',
           'plinth',
           1
       );
