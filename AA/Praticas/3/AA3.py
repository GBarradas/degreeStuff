from asyncio import CancelledError
import pandas as pd
import matplotlib.pyplot as plt
import sklearn as skl
import seaborn as sns
from sklearn.utils import Bunch
from sklearn.datasets import load_breast_cancer


cancer =load_breast_cancer()
data = cancer
df=pd.DataFrame(data.data,columns=data.feature_names)
df["target"]= data.target
selecao=df.iloc[:,[1,3,5,7,30]]
print(selecao.dtypes)
sns.pairplot(selecao, hue="mean texture")
plt.show()