## Objective
Use existing data to discover periodicity in the embryogenetic process.

## Participants
Bradly Alicea, Richard Gordon, Ujjwal Singh, Mayukh Deb, Jesse Parent

## Division of Labor
Mayukh (division events analysis, need a histogram of developmental time (bin size 50 minutes) versus numer of cells/events in bin.

Ujjwal (data analysis, frequency analysis, machine learning)

Bradly Alicea (coordination, analysis, data science).

Jesse Parent (manuscript review, ???)

Richard Gordon (manuscript review, ???)

## Datasets
_C. elegans_ cell divisions (rounds of division), Zebrafish (Zygote-Cleavage stage) [ZFIN](https://zfin.org/zf_info/zfbook/stages/index.html), simulated data for 512 cells (control).

Model            |  Measure                |  Control  |
-----------------|-------------------------|-----------|
*C. elegans*     | Division to 450 minutes | N         |
Zebrafish        | Division to 450 minutes | N         |
Simulated Embryo | Division to 450 minutes | Y         |

Experiments with simulated embryo (non-control), how do we differentiate the division process? Does cyclic behavior (division events occduring in waves) lead to or favor structural asymmetries?

Can we simulate the _C. elegans_ and Zebrafish data in a way that shifts the shape and timing regime of cell division? Realign the _x,y,z_ position or time (_t_)? 5-D representation (_x,y,z,t,$\theta_$), where theta is the shape parameter.
