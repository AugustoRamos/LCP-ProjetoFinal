/*drop schema FaceFood'*/

CREATE SCHEMA `FaceFood` DEFAULT CHARACTER SET utf8 ;


use FaceFood;

CREATE TABLE `FaceFood`.`Produtos` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(120) NOT NULL,
  `PrecoDeCusto` FLOAT NOT NULL,
  `PrecoDeVenda` FLOAT NOT NULL,
  `QuantidadeEstoque` INT NOT NULL,
  `CodigoDeBarras` VARCHAR(45) NOT NULL,
  `QuantidadeMinimaEstoque` INT NOT NULL,
  PRIMARY KEY (`Id`));


use FaceFood;

CREATE TABLE `FaceFood`.`Vendas` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `FormaPagamento` INT NOT NULL,
  `Preco` FLOAT NOT NULL,
  `Data` DATETIME NOT NULL,
  PRIMARY KEY (`Id`) );


use FaceFood;

CREATE TABLE `Venda_Produtos` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `ProdutoId` INT NOT NULL,
  `VendaId` INT NOT NULL,
  `Quantidade` FLOAT NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `ProdutoId` (`ProdutoId`),
  KEY `VendaId` (`VendaId`),
  CONSTRAINT `Venda_Produtos_ibfk_1` FOREIGN KEY (`ProdutoId`) REFERENCES `Produtos` (`Id`),
  CONSTRAINT `Venda_Produtos_ibfk_2` FOREIGN KEY (`VendaId`) REFERENCES `Vendas` (`Id`)
)



INSERT INTO produtos (Nome, PrecoDeCusto, PrecoDeVenda, QuantidadeEstoque, CodigoDeBarras, QuantidadeMinimaEstoque) VALUES ('Salsicha', 5, 8, 100, '', 5)
INSERT INTO produtos (Nome, PrecoDeCusto, PrecoDeVenda, QuantidadeEstoque, CodigoDeBarras, QuantidadeMinimaEstoque) VALUES ('frango', 2, 7, 10, '', 50)