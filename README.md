# Gestion de Scolarité
## Objectif
L'objectif de ce travail est la mise en place d'une application Android permettant de gérer les activités de base d'une scolarité ; parmi lesquelles nous pouvons citer :
- La saisie des filières
- La gestion des modules par filière
- La gestion des modules par niveau
- La gestion des inscriptions des étudiants
- La saisie des notes
- L’édition des bulletins de notes
L'application doit également calculer la moyenne des étudiants.

Modèle de données : 
SQLite

<p align="middle">
  <img src="https://user-images.githubusercontent.com/65272079/154357896-f9e067c8-a703-48a8-8151-af7a0ad76342.png" height="500px"/>
  <img src="https://user-images.githubusercontent.com/65272079/154357912-b82ac006-ad38-4468-bd58-d52bf57c5d55.png" height="500px"/> 
</p>


## Page d'Accueil

La page d'accueil contient les autres destinations. Chaque destination est représentée par un CardView (Filières, Modules, Etudiants, Plannings, Notes, Bulletins).

<p align="middle">
  <img src="https://user-images.githubusercontent.com/65272079/154367088-17df007c-1470-4842-a273-ff695ae7bbb7.jpg" height="500px"/>
  <img src="https://user-images.githubusercontent.com/65272079/154367096-91d8d448-f591-46ae-8c9d-62c16fdd33fb.jpg" height="500px"/> 
</p>

## Page des filières

### Ajouter une filière

Pour ajouter une filière, on écrit le nom de la filière désirée puis on clique sur le bouton « check ». La filière s’ajoute dans la base de données.

<p align="middle">
  <img src="https://user-images.githubusercontent.com/65272079/154367902-5c8c5cac-edf8-40b3-8399-38a5f508937e.jpg" height="500px"/>
</p> 

### Supprimer une filière

Pour supprimer une filière, on clique tout simplement sur le bouton de la poubelle sur le tableau des filières.

<p align="middle">
  <img src="https://user-images.githubusercontent.com/65272079/154367906-ea876a99-c389-4241-8105-54d6ac5d35c5.jpg" height="500px"/>
</p> 

## Page des modules

### Ajouter un module

Pour ajouter un module, on écrit le nom du module désirée puis on clique sur le bouton « check ». Le module s’ajoute dans la base de données.

<p align="middle">
  <img src="https://user-images.githubusercontent.com/65272079/154373744-fdec6e00-c47c-4841-87d9-09a391bbb6f0.jpg" height="500px"/>
</p> 

### Supprimer un module

Pour supprimer un module, on clique tout simplement sur le bouton de la poubelle sur le tableau des modules.

<p align="middle">
  <img src="https://user-images.githubusercontent.com/65272079/154372697-c56a6fc5-f331-4713-b2ce-edcb454f107f.jpg" height="500px"/>
</p> 


## Page des étudiants

Dans cette page, on pourra ajouter un étudiant, en définissant son nom, prénom, CIN, filière et niveau (planning).

<p align="middle">
  <img src="https://user-images.githubusercontent.com/65272079/154373051-cb41d7db-190f-4b6e-bfff-4434504140fc.jpg" height="500px"/>
  <img src="https://user-images.githubusercontent.com/65272079/154373058-0bcb81f3-c67e-4dd6-954f-31be95cd0834.jpg" height="500px"/>
</p> 


## Page des plannings

Pour créer un planning, on choisit tout d’abord la filière et le niveau, puis on se dirige vers une autre page ou on pourra ajouter les modules que l’on veut dans ce planning. Puis on valide et on confirme. Le planning est ajouté dans notre base de données.

<p align="middle">
  <img src="https://user-images.githubusercontent.com/65272079/154373828-63de0717-cc87-4697-b755-a54bc5e18861.jpg" height="500px"/>
  <img src="https://user-images.githubusercontent.com/65272079/154373851-29cdaecb-fe50-4167-a92d-7e5e00422830.jpg" height="500px"/>
  <img src="https://user-images.githubusercontent.com/65272079/154373877-046ae653-47d8-4b1e-810f-e446ae883f79.jpg" height="500px"/>
  <img src="https://user-images.githubusercontent.com/65272079/154373886-1564ef4f-8c4e-42ae-bc9f-9635a867b8d3.jpg" height="500px"/>
  <img src="https://user-images.githubusercontent.com/65272079/154373897-57c51a28-e65f-4403-92e0-a3aed8f2a9a3.jpg" height="500px"/>
</p> 


## Page des notes

On peut ajoute la note aux modules de l'étudiant sélectionné.

<p align="middle">
  <img src="https://user-images.githubusercontent.com/65272079/154371029-2dc3eb51-dbbb-4043-af38-c7089c4ab912.jpg" height="500px"/>
</p> 


## Page des bulletins

On pourra consulter les bulletins de tous les étudiants de n’importe quel filière/niveau.

<p align="middle">
  <img src="https://user-images.githubusercontent.com/65272079/154370853-325cfe2c-3c83-4061-8b39-a211bdf062c4.jpg" height="500px"/>
</p> 
