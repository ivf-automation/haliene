from PreProcessor import PreProcessor



IMAGES_DIR = 'src/images'
INPUT_DIR = IMAGES_DIR + '/input/train'
OUTPUT_DIR = IMAGES_DIR + '/output'

DEBUG_IMGNAME_ALLOWLIST=[
    # '20220125_110842',
    # '20220610_153905',
    # '20220510_163902',
    '20220610_154147',
    'all_dust',
    'all_dust2',
    'all_dust3'
    # '20220122_102931',
    # '20220610_153905',
    # '20220610_153800',
    # '20220118_145609'
    ]




def main():
    # preprocessor_runtime = PreProcessor(input_dir=INPUT_DIR, output_dir=OUTPUT_DIR)
    preprocessor_runtime = PreProcessor(input_dir=INPUT_DIR, output_dir=OUTPUT_DIR, debug=True, debug_imgname_allowlist=DEBUG_IMGNAME_ALLOWLIST, should_crop_image=False)
    preprocessor_runtime.preprocess_all()

if __name__ == '__main__':
    main()
