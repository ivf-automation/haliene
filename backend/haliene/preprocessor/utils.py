import random
import string

def generate_random_id(n):
    random_val = ''.join(random.choices(string.ascii_lowercase, k=n))
    return random_val