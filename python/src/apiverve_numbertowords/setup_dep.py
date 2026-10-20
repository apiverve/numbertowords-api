from setuptools import setup, find_packages

setup(
    name='apiverve_numbertowords',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Number to Words is a number to words API that converts numeric values into written cardinal words and counts whole and fractional digits. Pass any integer or float to get the spelled-out text along with digit counts and locale information.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/numbertowords?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
