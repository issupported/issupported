INSERT INTO public.attribute (id, name) VALUES (1, 'Border-radius');
INSERT INTO public.attribute (id, name) VALUES (2, 'Cursor');

INSERT INTO public.browser (id, name) VALUES (1, 'Chrome');
INSERT INTO public.browser (id, name) VALUES (2, 'IE');

INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version, supported) VALUES (1, 1, '49', 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version, supported) VALUES (1, 1, '51', 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version, supported) VALUES (1, 1, '52', 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version, supported) VALUES (1, 2, '49', 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version, supported) VALUES (1, 2, '51', 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version, supported) VALUES (1, 2, '52', 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version, supported) VALUES (2, 2, '8', 'PARTIAL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version, supported) VALUES (2, 1, '8', 'NOT');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version, supported) VALUES (2, 1, '11', 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, version, supported) VALUES (2, 2, '11', 'FULL');