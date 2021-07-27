create database EspacoFit;
use EspacoFit;

create table if not exists Bairro(
	id int not null auto_increment primary key,
    descricao varchar(100)
);

create table if not exists Cidade(
	id int not null auto_increment primary key,
    descricao varchar(100)
);

create table if not exists Cep(
	idCidade int not null,
    idBairro int not null,
    id int not null auto_increment primary key,
    cep varchar(8),
    logradouro varchar(100),
    obs varchar(100),
    constraint fk_Cep_Cidade foreign key (idCidade) references Cidade(id) ON DELETE CASCADE,
    constraint fk_Cep_Bairro foreign key (idBairro) references Bairro(id) ON DELETE CASCADE
);

create table if not exists Aluno(
	idCep int not null,
	id int not null auto_increment primary key,
    nome varchar(100) not null,
    rg varchar(12),
    cpf varchar(11),
    dataNasc date,
    complementoEndereco varchar(100),
    fone1 varchar(11),
    fone2 varchar(11),
    email varchar(100),
    obs varchar(100),
    constraint fk_Aluno_Cep foreign key (idCep) references Cep(id) ON DELETE CASCADE
);

create table if not exists Personal(
	idCep int not null,
	id int not null auto_increment primary key,
    nome varchar(100) not null,
    rg varchar(12),
    cpf varchar(11) not null,
    dataNasc date,
    complementoEndereco varchar(100),
    fone1 varchar(11),
    fone2 varchar(11),
    email varchar(100),
    obs varchar(100),
    constraint fk_Personal_Cep foreign key (idCep) references Cep(id) ON DELETE CASCADE
);

create table if not exists Fornecedor(
	idCep int not null,
	id int not null auto_increment primary key,
    nome varchar(100) not null,
    razaoSocial varchar(100),
    cnpj varchar(14),
    inscEstadual varchar(11) not null,
    complementoEndereco varchar(100),
    fone1 varchar(11),
    fone2 varchar(11),
    email varchar(100),
    obs varchar(100),
    constraint fk_Fornecedor_Cep foreign key (idCep) references Cep(id) ON DELETE CASCADE
);

create table if not exists Produto(
	id int not null auto_increment primary key,
    descricao varchar(60),
    unidadeCompra varchar(3),
    unidadeVenda varchar(3),
    correlacaoUnidade float,
    valor float,
    quantidadeEstoque int,
    codigoBarra varchar(13),
    obs varchar(100)
);

create table if not exists Compras(
	idFornecedor int not null,
    id int not null auto_increment primary key,
    identificacao varchar(100) not null,
    dataCompra date,
    valorTotal float,
    obs varchar(100),
    constraint fk_Compras_Fornecedor foreign key (idFornecedor) references Fornecedor(id) ON DELETE CASCADE
);

create table if not exists Vendas(
	idAluno int not null,
    idPersonal int not null,
    id int not null auto_increment primary key,
    identificacao varchar(100) not null,
    dataVenda date,
    valorTotal float,
    obs varchar(100),
    constraint fk_Vendas_Aluno foreign key (idAluno) references Aluno(id) ON DELETE CASCADE,
    constraint fk_Vendas_Personal foreign key (idPersonal) references Personal(id) ON DELETE CASCADE
);

create table if not exists ItensVenda(
    idProduto int not null,
	idVendas int not null,
    id int not null auto_increment primary key,
    quantidade int,
    subtotal float,
    constraint fk_ItensVenda_Produto foreign key (idProduto) references Produto(id) ON DELETE CASCADE,
    constraint fk_ItensVenda_Vendas foreign key (idVendas) references Vendas(id) ON DELETE CASCADE
);

create table if not exists ItensCompra(
    idProduto int not null,
    idCompras int not null,
    id int not null auto_increment primary key,
    quantidade int,
    subtotal float,
    constraint fk_ItensCompra_Produto foreign key (idProduto) references Produto(id) ON DELETE CASCADE,
    constraint fk_ItensCompra_Compras foreign key (idCompras) references Compras(id) ON DELETE CASCADE
);

create table if not exists Pagar(
	idCompras int not null,
    id int not null auto_increment primary key,
    dataEmissao date,
    valorEmitido float,
    dataVencimento date,
    dataPagamento date,
    valorDesconto float,
    valorAcrescimo float,
    valorPago float,
    statusPagar varchar(1),
    constraint fk_Pagar_Compras foreign key (idCompras) references Compras(id) ON DELETE CASCADE
);

create table if not exists Receber(
	idVendas int not null,
    id int not null auto_increment primary key,
    dataEmissao date,
    valorEmitido float,
    dataVencimento date,
    dataPagamento date,
    valorDesconto float,
    valorAcrescimo float,
    valorPago float,
    statusReceber varchar(1),
    constraint fk_Receber_Vendas foreign key (idVendas) references Vendas(id) ON DELETE CASCADE
);