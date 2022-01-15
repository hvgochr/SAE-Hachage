# SAE 1.02: Algorithmique avancée

## Découverte des tables de hashage

---

## Sommaire:

Voici un sommaire de l'organisation de ce ReadMe:

- [Le Projet](#le-projet)
- [Comment télécharger et exécuter?](#compilation-du-code--lancement-des-tests-)
- [Réponses aux questions](#réponses-aux-questions-)
- [Auteurs](#les-auteurs)

---

## Le Projet:

Ce projet entre dans le cadre de la SAE 1.02 d'Algorithmique avancée de 1ère année en BUT Informatique.
Le but de ce projet est de découvrir les tables de hashage à travers le codage de ce progremme en Java.
Pour cela, un sujet avec des indications claires et quelques questions de mathématiques nous a été fourni.
Après la réponse à ces questions, nous avons été aptes à réaliser tout la partie liée au codage et présente dans ce git.

[Retour Au Début](#sae-1.02:-algorithmique-avancée)

---
## Comment télécharger et exécuter?

>**Étape 1:**

Pour télécharger le jeu vous devrez vous rendre sur le site: (https://github.com/hvgochr/SAE-Hachage)

>**Étape 2:**

Rendez vous ensuite dans la section `Releases` (https://github.com/hvgochr/SAE-Hachage/releases), où vous trouverez toutes les releases du programme. 
Cliquez de préférence sur la dernière version disponible, puis rendez vous dans l'onglets `Assets`.

>**Étape 3:**

Téléchargez tous les fichiers en cliquant sur ces derniers, puis déplacez-les dans un dossier.
Ensuite, grâce à l'invite de commande, rendez vous dans ce dossier à l'aide de la commande `cd`. 

>**Étape 4:**

Une fois dans le dossier, entrez la commande `chmod u+x lancement.sh`.
Ensuite, entrez la commande `./lancement.sh`, et le programme démarre.

**Vous avez maintenant affiché sur votre écran les résultats du programme.**

[Retour Au Début](#sommaire)

---

## Réponses aux questions mathématiques:

>**Question 1:**

S'il y a 256 caractères possibles, |U| vaut donc:

`|U| = 256^1+256^2+256^3+ ... +256^28+256^29+256^30 ≈ 1.77*10^72`

Et s'il y a 32 caractères possibles, |U| vaut donc:

`|U| = 32^1+32^2+32^3+ ... +32^28+32^29+32^30 ≈ 1.47*10^47`

>**Question 3:**

Pour stocker un élément u de U, il faudrait `Log2(1.77*10^72) ≈ 240` octets.

>**Question 18:**

Pour convertir une chaîne `s = Ck ... Co` en entier, il faudrait effectuer `k(k+1)/2` multiplications.

>**Question 27:**

Après exécution du programme, on remarque qu'il y a `14445 mots` différents dans le fichier "LeRougeEtLeNoir.txt". 

[Retour Au Début](#sommaire)

---

## Les auteurs:

- Mathéo CALAS - matheo.calas@etu.umontpellier.fr
- Hugo CHARRADE - hugo.charrade@etu.umontpellier.fr
- Kim HARRIBAUD - kim.harribaud@etu.umontpellier.fr
- Ewan TREGUIER - ewan.treguier@etu.umontpellier.fr

[Retour Au Début](#sommaire)

---

BUT Informatique - IUT de Montpellier antenne de Sète 
